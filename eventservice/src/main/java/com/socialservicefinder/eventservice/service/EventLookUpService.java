package com.socialservicefinder.eventservice.service;

import com.socialservicefinder.eventservice.dto.EventLookUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventLookUpService {
    EventLookUp save(EventLookUp eventLookUp);

    void delete(EventLookUp eventLookUp);

    Iterable<EventLookUp> findAll();

    Page<EventLookUp> findEventLookUpByEventInfoContaining(String query, Pageable pageable);
}