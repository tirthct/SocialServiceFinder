package com.socialservicefinder.eventservice.dto;

public class FetchMyEvents {
    private String id;
    private boolean isOrganizer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsOrganizer() {
        return isOrganizer;
    }

    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }

    @Override
    public String toString() {
        return "Fetching events for [id=" + id + ", " + "isOrganizer=" + isOrganizer + "]";
    }
}
