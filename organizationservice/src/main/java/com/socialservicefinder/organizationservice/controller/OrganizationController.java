package com.socialservicefinder.organizationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialservicefinder.organizationservice.dto.Organization;
import com.socialservicefinder.organizationservice.exceptions.InvalidOrganizationException;
import com.socialservicefinder.organizationservice.service.OrganizationService;

@RestController
@RequestMapping(path = "api/v1/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @GetMapping
    public List<Organization> getOrganizations() {

        return organizationService.getOrganizations();
    }

    @PostMapping
    public ResponseEntity<String> addOrganization(@RequestBody Organization organization) {
        try {
            organizationService.addOrganization(organization);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch (InvalidOrganizationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
