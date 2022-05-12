package com.socialservicefinder.eventservice.service;

import com.socialservicefinder.eventservice.dto.RegisteredEvents;
import com.socialservicefinder.eventservice.repository.RegisteredEventsRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class RegisteredEventsLookUpServiceImpl implements RegisteredEventsLookUpService {
    private final RegisteredEventsRepository registeredEventsRepository;

    public RegisteredEventsLookUpServiceImpl(RegisteredEventsRepository registeredEventsRepository) {
        this.registeredEventsRepository = registeredEventsRepository;
    }

    @Override
    public RegisteredEvents createRegisteredEvents(String userId) {
        return registeredEventsRepository.save(new RegisteredEvents(userId, new ArrayList<>()));
    }

    @Override
    public RegisteredEvents save(RegisteredEvents registeredEvents) {
        return registeredEventsRepository.save(registeredEvents);
    }

    @Override
    public List<String> fetchEventIdsByUserId(String userId) {
        return registeredEventsRepository.findRegisteredEventsByUserId(userId).getEventIds();
    }

    @Override
    public void delete(RegisteredEvents registeredEvents) {
        registeredEventsRepository.delete(registeredEvents);
    }
}
