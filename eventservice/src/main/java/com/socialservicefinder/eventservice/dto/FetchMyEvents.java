package com.socialservicefinder.eventservice.dto;

public class FetchMyEvents {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fetching events for [id=" + id + "]";
    }
}
