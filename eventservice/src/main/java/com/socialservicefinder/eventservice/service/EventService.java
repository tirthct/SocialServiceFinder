package com.socialservicefinder.eventservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.dto.EventEntity;
import com.socialservicefinder.eventservice.repository.EventRepository;
import com.socialservicefinder.eventservice.repository.OrganizationRepository;

@Service
@Component
public class EventService {
	private final EventRepository eventRepository;
	private final OrganizationRepository organizationRepository;

	@Autowired
	public EventService(EventRepository eventRepository, OrganizationRepository organizationRepository) {
		this.eventRepository = eventRepository;
		this.organizationRepository = organizationRepository;
	}

	public Event addEvent(Event event) {
		if(event.getName() == null || event.getName().isEmpty())
			throw new IllegalArgumentException("Event Name cannot be null");
		if(event.getStartTime() == null || event.getEndTime() == null || event.getStartTime().isAfter(event.getEndTime()))
			throw new IllegalArgumentException("Start and/or end date are not valid");
		if(organizationRepository.findById(event.getOrganizationId()) == null)
			throw new IllegalArgumentException("Invalid organization");
		EventEntity entity = mapToEntity(event);
		eventRepository.insert(entity);
		return event;
	}
	
	public List<Event> getEvents(){
		List<EventEntity> entities = eventRepository.findAll();
		List<Event> events = new ArrayList<Event>();
		for(EventEntity entity : entities) {
			events.add(mapToDto(entity));
		}
		return events;
	}
	
	private Event mapToDto(EventEntity entity) {
		Event event = new Event(entity.getName(), entity.getStartTime(), entity.getEndTime(),
				entity.getCapacity(), entity.getAddress(), entity.getDescription(), entity.getOrganizationId());
		return event;
	}

	private EventEntity mapToEntity(Event event) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		EventEntity entity = new EventEntity(uuid, event.getName(), event.getStartTime(), event.getEndTime(),
				event.getCapacity(), event.getAddress(), event.getDescription(), event.getOrganizationId());
		return entity;
	}
}
