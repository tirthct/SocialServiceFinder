package com.socialservicefinder.eventservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;
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
    private String email;
    private String pocName;
    private Date startDate;
    private Date endDate;
    private String organizationId;
    private Set<String> registeredUsers;
    private boolean deleted;

    @Override
    public String toString() {
        return "Event [name=" + name + ", description=" + description + ", phoneNo=" + phoneNo + ", email=" + email + ", POCName=" + pocName
                + ", address=" + address + ", city=" + city + ", rewards=" + rewards + ", pinCode="
                + pinCode + ", startDate=" + startDate.toString() + ", endDate=" + endDate.toString() + ", isDeleted=" + deleted + "]";
    }

    public Event() {
        super();
    }

    public Event(String name, String description, String phoneNo, String address, String city, long rewards, long pinCode, String email, String pocName, Date startDate, Date endDate, boolean deleted) {
        this.name = name;
        this.description = description;
        this.phoneNo = phoneNo;
        this.address = address;
        this.city = city;
        this.rewards = rewards;
        this.pinCode = pinCode;
        this.email = email;
        this.pocName = pocName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPocName() {
        return pocName;
    }

    public void setPocName(String pocName) {
        this.pocName = pocName;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Set<String> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Set<String> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public void addRegisteredUser(String id) {
        registeredUsers.add(id);
    }
}
