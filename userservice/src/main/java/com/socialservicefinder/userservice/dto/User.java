package com.socialservicefinder.userservice.dto;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document("users")
public class User {
	@Id
	private String id;
	private String name;
	private String email;
	private LocalDate dob;
	private String phoneNo;
	private String address;
	private String city;
	private String password;
	private long pinCode;
	private List<OrganizationTypes> preferences;
	private long rewards;

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dob=" + dob + ", phoneNo=" + phoneNo + ", address="
				+ address + ", city=" + city + ", pinCode=" + pinCode + ", preferences=" + preferences + ", id="+ id + "]";
	}

	public User() {
		super();
	}

	public User(String name, String email, LocalDate dob, String phoneNo, String address, String city, String password,
				long pinCode, List<OrganizationTypes> preferences) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.password = password;
		this.pinCode = pinCode;
		this.preferences = preferences;
	}

	public void assign_id(){
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public List<OrganizationTypes> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<OrganizationTypes> preferences) {
		this.preferences = preferences;
	}

	public long getRewards() {
		return rewards;
	}

	public void setRewards(long rewards) {
		this.rewards = rewards;
	}
}
