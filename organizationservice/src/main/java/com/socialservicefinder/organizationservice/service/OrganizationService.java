package com.socialservicefinder.organizationservice.service;

import java.util.List;

import com.mongodb.MongoWriteException;
import com.socialservicefinder.organizationservice.dto.Login;
import com.socialservicefinder.organizationservice.exceptions.InvalidLoginException;
import com.socialservicefinder.organizationservice.exceptions.InvalidOrganizationException;
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
    private final int ASSIGN_ID_TRIES;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) throws Exception {
        this.organizationRepository = organizationRepository;
        this.codec = new Codec();
        this.ASSIGN_ID_TRIES = 3;
    }

    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    public void addOrganization(Organization organization) {
        if (organization == null || organization.getEmail() == null || organization.getName() == null
                || organization.getPassword() == null)
            throw new IllegalArgumentException("organization, email, name or password cannot be null or empty");

        organization.setPassword(codec.encrypt(organization.getPassword()));
        insertOrganization(organization);
    }

    public void updateOrganization(Organization organization) {
        if (organization == null || organization.getEmail() == null || organization.getName() == null)
            throw new IllegalArgumentException("organization, email, name cannot be null or empty");
        Organization oldOrganization = organizationRepository.findById(organization.getId()).get();
        if (organization.getPassword().length() == 0) {
            organization.setPassword(oldOrganization.getPassword());
        } else {
            organization.setPassword(codec.encrypt(organization.getPassword()));
        }
        updateOrganizations(organization);
    }

    public void deleteOrganization(Organization organization) {
        boolean id_assigned = false;
        for (int tries = 0; tries < ASSIGN_ID_TRIES; tries++) {
            try {
                organization.setDeleted(true);
                organizationRepository.save(organization);
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidOrganizationException("Unable to delete Organization, please try after sometime.");
    }

    private void updateOrganizations(Organization organization) {
        boolean id_assigned = false;
        for (int tries = 0; tries < ASSIGN_ID_TRIES; tries++) {
            try {
                organizationRepository.save(organization);
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidOrganizationException("Please try after sometime.");
    }

    private void insertOrganization(Organization organization) {
        // Try assigning ID to organization for TRIES number of times.
        boolean id_assigned = false;
        for (int tries = 0; tries < ASSIGN_ID_TRIES; tries++) {
            try {
                organization.assign_id();
                organizationRepository.insert(organization);
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidOrganizationException("Please try after sometime.");
    }

    public Organization getAuthOrganization(Login login) {
        if (login == null || login.getEmail() == null || login.getPassword() == null)
            throw new IllegalArgumentException("Login object or email or password cannot be null");

        login.setPassword(codec.encrypt(login.getPassword()));
        Organization organization = organizationRepository.findByEmailAndDeletedFalse(login.getEmail());
        if (organization != null && organization.getPassword().equals(login.getPassword())) {
            System.out.println(organization);
            return organization;
        } else
            throw new InvalidLoginException("Authentication Failed");
    }
}
