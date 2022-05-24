package com.socialservicefinder.organizationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialservicefinder.organizationservice.dto.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
    Organization findOrganizationByEmailAndDeleted(String email, boolean isDeleted);
}
