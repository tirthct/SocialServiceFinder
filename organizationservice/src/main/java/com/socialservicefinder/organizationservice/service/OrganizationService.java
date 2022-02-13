package com.socialservicefinder.organizationservice.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.socialservicefinder.organizationservice.dto.Organization;
import com.socialservicefinder.organizationservice.repository.OrganizationRepository;

@Service
@Component
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getOrganizations(){
        return organizationRepository.findAll();
    }

    public void addOrganization(Organization organization) {
        if(organization == null || organization.getEmail() == null || organization.getName() == null)
            throw new IllegalArgumentException("organization, email or name cannot be null or empty");
        organizationRepository.insert(organization);
    }
}
