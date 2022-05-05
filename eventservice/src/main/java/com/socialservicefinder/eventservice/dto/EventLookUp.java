package com.socialservicefinder.eventservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "eventlookup")
public class EventLookUp {
    @Id
    private String id;
    private String eventId;
    private String eventInfo;

    public EventLookUp(String id, String eventId, String eventInfo) {
        this.id = id;
        this.eventId = eventId;
        this.eventInfo = eventInfo;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    @Override
    public String toString() {
        return "EventLookUp{" +
                "id=" + id + ", " +
                "eventId=" + eventId + ", " +
                "eventInfo=" + eventInfo + "}";
    }
}
