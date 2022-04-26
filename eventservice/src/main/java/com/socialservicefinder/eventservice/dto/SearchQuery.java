package com.socialservicefinder.eventservice.dto;

public class SearchQuery {
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Search Query [query=" + query + "]";
    }
}
