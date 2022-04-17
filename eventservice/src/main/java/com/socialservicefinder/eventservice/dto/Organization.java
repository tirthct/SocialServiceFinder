package com.socialservicefinder.eventservice.dto;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("organizations")
public class Organization {
	@Id
	private String id;
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	private String city;
	private long pinCode;
	private OrganizationTypes organization_type;

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", city=" + city + ", pinCode=" + pinCode + ", organization_type="
				+ organization_type + "]";
	}

	public Organization() {
		super();
	}

	public Organization(String name, String email, String phoneNo, String address, String city, long pinCode,
						OrganizationTypes organization_type) {
		//TODO: Add check for unique uuid.
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.organization_type = organization_type;
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

	public OrganizationTypes getOrganizationType() {
		return organization_type;
	}

	public void setOrganizationType(OrganizationTypes organization_type) {
		this.organization_type = organization_type;
	}
}
