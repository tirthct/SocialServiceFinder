package com.socialservicefinder.eventservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.service.EventService;

@RestController
@RequestMapping("api/v1/events")
public class EventsController {
	private final EventService eventService;

	@Autowired
	public EventsController(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping
	public List<Event> getEvents() {
		return eventService.getEvents();
	}

	@PostMapping
	public ResponseEntity<String> addEvent(@RequestBody Event event) {
		try {
			var insertedEvent = eventService.addEvent(event);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(insertedEvent.toString());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
