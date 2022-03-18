package com.socialservicefinder.eventservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialservicefinder.eventservice.dto.EventEntity;

public interface EventRepository extends MongoRepository<EventEntity, String> {

}
