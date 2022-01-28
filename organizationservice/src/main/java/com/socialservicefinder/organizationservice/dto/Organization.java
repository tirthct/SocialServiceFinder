package com.socialservicefinder.organizationservice.dto;

import java.time.LocalDate;
import java.util.List;

public class Organization {
	private long id;
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	private String city;
	private long pinCode;
	private OrganizationTypes organization_type;

	public Organization(long id, String name, String email, String phoneNo, String address, String city,
						long pinCode, OrganizationTypes organization_type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.organization_type = organization_type;
	}

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
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.organization_type = organization_type;
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
