package com.socialservicefinder.eventservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialservicefinder.eventservice.dto.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String>{

}
