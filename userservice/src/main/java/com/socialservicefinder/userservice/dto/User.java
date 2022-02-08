package com.socialservicefinder.userservice.dto;

import java.time.LocalDate;
import java.util.List;

public class User {
	private long id;
	private String name;
	private String email;
	private LocalDate dob;
	private String phoneNo;
	private String address;
	private String city;
	private long pinCode;
	private List<OrganizationTypes> preferences;

	public User(long id, String name, String email, LocalDate dob, String phoneNo, String address, String city,
			long pinCode, List<OrganizationTypes> preferences) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.preferences = preferences;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", city=" + city + ", pinCode=" + pinCode + ", preferences=" + preferences
				+ "]";
	}

	public User() {
		super();
	}

	public User(String name, String email, LocalDate dob, String phoneNo, String address, String city, long pinCode,
			List<OrganizationTypes> preferences) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.preferences = preferences;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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


}
