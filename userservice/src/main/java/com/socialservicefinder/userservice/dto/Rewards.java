package com.socialservicefinder.userservice.dto;

public class Rewards {
    String id;
    long rewards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getRewards() {
        return rewards;
    }

    public void setRewards(long rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString(){
        return "Rewards for [id=" + id + " rewards=" +rewards+"]";
    }
}
