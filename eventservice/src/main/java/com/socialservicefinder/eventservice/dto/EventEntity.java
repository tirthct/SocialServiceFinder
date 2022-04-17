package com.socialservicefinder.eventservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("events")
public class EventEntity {
	@Id
	private String id;
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int capacity;
	private String address;
	private String description;
	private String organizationId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EventEntity(String id, String name, LocalDateTime startTime, LocalDateTime endTime, int capacity, String address,
			String description, String organizationId) {
		super();
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.capacity = capacity;
		this.address = address;
		this.description = description;
		this.setOrganizationId(organizationId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
}
