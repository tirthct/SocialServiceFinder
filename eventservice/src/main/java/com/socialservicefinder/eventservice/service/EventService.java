package com.socialservicefinder.eventservice.service;

import com.mongodb.MongoWriteException;
import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.exceptions.InvalidEventException;
import com.socialservicefinder.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class EventService {
    private EventRepository eventRepository;
    private final int NO_OF_TRIES;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.NO_OF_TRIES = 5;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getMatchingEvents(String name) {
        return eventRepository.findEventByNameContains(name);
    }

    public void addEvent(Event e) {
        if (e == null || e.getName() == null || e.getAddress() == null || e.getDescription() == null) {
            throw new InvalidEventException("name, address or description cannot be null or empty");
        }
        insertEvent(e);
    }

    public void insertEvent(Event e) {
        boolean id_assigned = false;
        for (int tries = 0; tries < NO_OF_TRIES; tries++) {
            try {
                e.assign_id();
                eventRepository.insert(e);
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidEventException("Please try after sometime.");
    }
}
