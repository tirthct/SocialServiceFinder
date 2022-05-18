package com.socialservicefinder.eventservice.service;

import com.mongodb.MongoWriteException;
import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.dto.EventLookUp;
import com.socialservicefinder.eventservice.exceptions.InvalidEventException;
import com.socialservicefinder.eventservice.repository.EventRepository;
import com.socialservicefinder.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        itr.forEach(events::add);
        return events;
    }

    public List<Event> fetchMyEvents(String id, boolean isOrganization) {
        List<String> eventIds;
        if (isOrganization) {
            return eventRepository.findEventByOrganizationId(id);
        } else {
            eventIds = userService.getEventIds(id);
            List<Event> events = new ArrayList<>();
            for (String eventId : eventIds) {
                Optional<Event> event = eventRepository.findById(eventId);
                event.ifPresent(events::add);
            }
            return events;
        }
    }

    public void addEvent(Event e) {
        if (e == null || e.getName() == null || e.getAddress() == null || e.getDescription() == null) {
            throw new InvalidEventException("name, address or description cannot be null or empty");
        }
        insertEvent(e);
    }

    public void updateEvent(Event e) {
        if (e == null || e.getName() == null || e.getAddress() == null || e.getDescription() == null) {
            throw new InvalidEventException("name, address or description cannot be null or empty");
        }
        updateEvents(e);
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
}
