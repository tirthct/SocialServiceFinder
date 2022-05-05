package com.socialservicefinder.eventservice.controller;

import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.dto.EventLookUp;
import com.socialservicefinder.eventservice.dto.SearchQuery;
import com.socialservicefinder.eventservice.exceptions.InvalidEventException;
import com.socialservicefinder.eventservice.service.EventLookUpService;
import com.socialservicefinder.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {
    private final EventService eventService;
    private final EventLookUpService eventLookUpService;

    @Autowired
    public EventController(EventService eventService, EventLookUpService eventLookUpService) {
        this.eventService = eventService;
        this.eventLookUpService = eventLookUpService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        try {
            eventService.addEvent(event);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (InvalidEventException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    @RequestMapping("/search/")
    public List<Event> getMatchingEvents(@RequestBody SearchQuery q) {
        try {
            if (q.getQuery().isEmpty()) {
                return Collections.emptyList();
            }
            Page<EventLookUp> eventLookUps = eventLookUpService.findEventLookUpByEventInfoContaining(q.getQuery(), PageRequest.of(0, 10));
            List<String> eventIds = new ArrayList<>();
            eventLookUps.forEach(x -> eventIds.add(x.getEventId()));
            List<Event> events = eventService.findEventsByIds(eventIds);
            for (Event e : events) {
                //Logging events coming from search
                System.out.println(e.toString());
            }
            System.out.println("Query String:" + q.getQuery());
            return events;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
