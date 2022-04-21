package com.socialservicefinder.eventservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("events")
public class Event {
    @Id
    private String id;
    private String name;
    private String description;
    private String phoneNo;
    private String address;
    private String city;
    private long rewards;
    private long pinCode;

    @Override
    public String toString() {
        return "Event [name=" + name + ", description=" + description + ", phoneNo=" + phoneNo
                + ", address=" + address + ", city=" + city + ", rewards=" + rewards + ", pinCode="
                + pinCode + "]";
    }

    public Event() {
        super();
    }

    public Event(String name, String description, String phoneNo, String address, String city, long rewards, long pinCode) {
        this.name = name;
        this.description = description;
        this.phoneNo = phoneNo;
        this.address = address;
        this.city = city;
        this.rewards = rewards;
        this.pinCode = pinCode;
    }

    public void assign_id() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getRewards() {
        return rewards;
    }

    public void setRewards(long rewards) {
        this.rewards = rewards;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }
}
