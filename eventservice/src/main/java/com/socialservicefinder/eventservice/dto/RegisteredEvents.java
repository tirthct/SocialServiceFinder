package com.socialservicefinder.eventservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("registeredEvents")
public class RegisteredEvents {
    @Id
    private String userId;
    private List<String> eventIds;

    public RegisteredEvents() {
        super();
    }

    public RegisteredEvents(String userId, List<String> eventIds) {
        this.userId = userId;
        this.eventIds = eventIds;
    }

    @Override
    public String toString() {
        StringBuilder events = new StringBuilder();
        for (String a : eventIds) {
            events.append(a).append(", ");
        }
        return "RegisteredEvent [userId=" + userId + ", eventIds=" + events + "]";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<String> eventIds) {
        this.eventIds = eventIds;
    }

    public void addEventId(String id) {
        eventIds.add(id);
    }
}
