package com.socialservicefinder.eventservice.service;

import com.mongodb.MongoWriteException;
import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.dto.EventLookUp;
import com.socialservicefinder.eventservice.dto.RegisterEvent;
import com.socialservicefinder.eventservice.exceptions.InvalidEventException;
import com.socialservicefinder.eventservice.repository.EventRepository;
import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.HashSet;

@Service
@Component
public class EventService {
    private final EventRepository eventRepository;
    private final EventLookUpService eventLookUpService;
    private final UserService userService;
    private final int NO_OF_TRIES;

    @Autowired
    public EventService(EventRepository eventRepository, EventLookUpService eventLookUpService, UserService userService) {
        this.eventRepository = eventRepository;
        this.eventLookUpService = eventLookUpService;
        this.userService = userService;
        this.NO_OF_TRIES = 5;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getMatchingEvents(String name) {
        return eventRepository.findEventByNameContains(name);
    }

    public List<Event> findEventsByIds(List<String> eventIds) {
        Iterable<Event> itr = eventRepository.findAllById(eventIds);
        List<Event> events = new ArrayList<>();
        while (itr.iterator().hasNext()) {
            Event e = itr.iterator().next();
            if (!e.isDeleted()) {
                events.add(e);
            }
        }
        return events;
    }

    public List<Event> fetchMyEvents(String id, boolean isOrganization, boolean isDeleted) {
        List<String> eventIds;
        if (isOrganization) {
            return eventRepository.findEventByOrganizationIdAndDeleted(id, isDeleted);
        } else {
            eventIds = userService.getEventIds(id);
            List<Event> events = new ArrayList<>();
            for (String eventId : eventIds) {
                Optional<Event> event = eventRepository.findById(eventId);
                if (event.isPresent() && !event.get().isDeleted()) {
                    events.add(event.get());
                }
            }
            return events;
        }
    }

    public void addEvent(Event e) {
        if (e == null || e.getName() == null || e.getAddress() == null || e.getDescription() == null) {
            throw new InvalidEventException("name, address or description cannot be null or empty");
        }
        e.setRegisteredUsers(new HashSet<>());
        insertEvent(e);
    }

    public void updateEvent(Event e) {
        if (e == null || e.getName() == null || e.getAddress() == null || e.getDescription() == null) {
            throw new InvalidEventException("name, address or description cannot be null or empty");
        }
        updateEvents(e);
    }

    public void deleteEvent(Event e) {
        if (e == null || e.getName() == null || e.getAddress() == null || e.getDescription() == null) {
            throw new InvalidEventException("Cannot delete event: name, address or description cannot be null or empty");
        }
        boolean id_assigned = false;
        for (int tries = 0; tries < NO_OF_TRIES; tries++) {
            try {
                e.setDeleted(true);
                eventRepository.save(e);
                eventLookUpService.delete(new EventLookUp(e.getId(), e.getId(), e.toString()));
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidEventException("Please try after sometime.");
    }

    private void updateEvents(Event e) {
        boolean id_assigned = false;
        for (int tries = 0; tries < NO_OF_TRIES; tries++) {
            try {
                eventRepository.save(e);
                eventLookUpService.save(new EventLookUp(e.getId(), e.getId(), e.toString()));
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidEventException("Please try after sometime.");
    }

    private void insertEvent(Event e) {
        boolean id_assigned = false;
        for (int tries = 0; tries < NO_OF_TRIES; tries++) {
            try {
                e.assign_id();
                eventRepository.insert(e);
                eventLookUpService.save(new EventLookUp(e.getId(), e.getId(), e.toString()));
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidEventException("Please try after sometime.");
    }

    public void registerUserForEvent(RegisterEvent eventToRegister) {
        try {
            String eventId = eventToRegister.getEventId();
            String userId = eventToRegister.getUserId();
            List<Event> events = findEventsByIds(Arrays.asList(eventId));
            User user = userService.getUserById(userId);

            for (Event event : events) {
                event.getRegisteredUsers().add(userId);
                //eventRepository.save(event);
                updateEvent(event);
                user.getEventIds().add(eventId);
                userService.setNewRewardsForUser(user, event.getRewards());
                userService.updateUser(user);
            }
        } catch (Exception exception) {
        }
    }
}
