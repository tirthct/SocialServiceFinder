package com.socialservicefinder.eventservice.repository;

import com.socialservicefinder.eventservice.dto.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
    public Event findEventByNameContains(String name);
}
