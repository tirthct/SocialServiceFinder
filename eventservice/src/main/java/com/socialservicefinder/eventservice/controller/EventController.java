package com.socialservicefinder.eventservice.controller;

import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.dto.SearchQuery;
import com.socialservicefinder.eventservice.exceptions.InvalidEventException;
import com.socialservicefinder.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
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
            List<Event> events = eventService.getMatchingEvents(q.getQuery());
            System.out.println(q.getQuery());
            return events;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
