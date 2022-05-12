package com.socialservicefinder.eventservice.service;

import com.socialservicefinder.eventservice.dto.RegisteredEvents;

import java.util.List;

public interface RegisteredEventsLookUpService {
    RegisteredEvents createRegisteredEvents(String userId);

    RegisteredEvents save(RegisteredEvents registeredEvents);

    List<String> fetchEventIdsByUserId(String userId);

    void delete(RegisteredEvents registeredEvents);
}
