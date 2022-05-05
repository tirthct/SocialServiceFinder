package com.socialservicefinder.eventservice.repository;

import com.socialservicefinder.eventservice.dto.EventLookUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EventLookUpRepository extends ElasticsearchRepository<EventLookUp, String> {
    Page<EventLookUp> findEventLookUpByEventInfoContaining(String query, Pageable pageable);
}