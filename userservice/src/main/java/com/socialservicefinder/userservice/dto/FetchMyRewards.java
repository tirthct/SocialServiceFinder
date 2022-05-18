package com.socialservicefinder.userservice.dto;

public class FetchMyRewards {
    String id;

    FetchMyRewards(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Fetching Rewards for [id=" + id +"]";
    }
}
