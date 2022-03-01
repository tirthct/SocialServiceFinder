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
    private final Codec codec;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) throws Exception {
        this.organizationRepository = organizationRepository;
        this.codec = new Codec();
    }

    public List<Organization> getOrganizations(){
        List<Organization> organizations = organizationRepository.findAll();
        for(Organization organization: organizations){
            organization.setPassword(codec.decrypt(organization.getPassword()));
        }
        return organizations;
    }

    public void addOrganization(Organization organization) {
        if(organization == null || organization.getEmail() == null || organization.getName() == null
                || organization.getPassword() == null)
            throw new IllegalArgumentException("organization, email, name or password cannot be null or empty");

        organization.setPassword(codec.encrypt(organization.getPassword()));
        organizationRepository.insert(organization);
    }
}
