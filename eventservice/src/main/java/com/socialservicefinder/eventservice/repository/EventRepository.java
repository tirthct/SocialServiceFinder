package com.socialservicefinder.eventservice.repository;

import com.socialservicefinder.eventservice.dto.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findEventByNameContains(String name);

    List<Event> findEventByOrganizationIdAndDeletedIs(String id, boolean isDeleted);

    List<Event> findEventByOrganizationIdAndDeleted(String id, boolean isDeleted);
}
