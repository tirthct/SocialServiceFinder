package com.socialservicefinder.organizationservice.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialservicefinder.organizationservice.dto.Login;
import com.socialservicefinder.organizationservice.exceptions.InvalidLoginException;
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

    @PostMapping("/login")
    public ResponseEntity<Organization> authOrganization(@RequestBody Login login) {
        try {
            var organization = organizationService.getAuthOrganization(login);
            return ResponseEntity.status(HttpStatus.OK).body(organization);
        } catch (InvalidLoginException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public List<Organization> getOrganizations() {

        return organizationService.getOrganizations();
    }

    @PostMapping
    public ResponseEntity<String> addOrganization(@RequestBody Organization organization) {
        try {
            organizationService.addOrganization(organization);
            ObjectMapper mapper = new ObjectMapper();
            return ResponseEntity.status(HttpStatus.OK).body(mapper.writeValueAsString(organization));
        } catch (InvalidOrganizationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
