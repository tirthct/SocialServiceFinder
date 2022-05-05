package com.socialservicefinder.eventservice.service;

import com.socialservicefinder.eventservice.dto.EventLookUp;
import com.socialservicefinder.eventservice.repository.EventLookUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EventLookUpServiceImpl implements EventLookUpService {
    private final EventLookUpRepository eventLookUpRepository;

    @Autowired
    public EventLookUpServiceImpl(EventLookUpRepository eventLookUpRepository) {
        this.eventLookUpRepository = eventLookUpRepository;
    }

    @Override
    public EventLookUp save(EventLookUp eventLookUp) {
        return eventLookUpRepository.save(eventLookUp);
    }

    @Override
    public void delete(EventLookUp eventLookUp) {
        eventLookUpRepository.delete(eventLookUp);
    }

    @Override
    public Iterable<EventLookUp> findAll() {
        return eventLookUpRepository.findAll();
    }

    @Override
    public Page<EventLookUp> findEventLookUpByEventInfoContaining(String query, Pageable pageable) {
        return eventLookUpRepository.findEventLookUpByEventInfoContaining(query, pageable);
    }
}