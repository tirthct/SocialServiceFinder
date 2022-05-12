package com.socialservicefinder.eventservice.repository;

import com.socialservicefinder.eventservice.dto.RegisteredEvents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisteredEventsRepository extends MongoRepository<RegisteredEvents, String> {
    RegisteredEvents findRegisteredEventsByUserId(String id);
}
