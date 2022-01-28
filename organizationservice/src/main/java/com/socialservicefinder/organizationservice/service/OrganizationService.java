package com.socialservicefinder.organizationservice.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.organizationservice.dto.OrganizationTypes;
import com.socialservicefinder.organizationservice.dto.Organization;


@Service
@Component
public class OrganizationService {
    public List<Organization> getOrganizations(){
        return List.of(
                new Organization(1, "Visamo Kids Foundation", "inquiries@visamo.com", "9499926165",
                        "Irvine Spectrum City Center", "Irvine", 92616, OrganizationTypes.orphanage),
                new Organization(2, "Shikoton", "help@shikoton.com", "9499926165",
                        "Campus Dr, St 2442, UCI road", "Irvine", 92618, OrganizationTypes.oldage),
                new Organization(3, "Norah Flower", "reachout@norah.com", "9499926165",
                        "28 Indianapolis street,", "Irvine", 92637, OrganizationTypes.environmental),
                new Organization(4, "Nosher Academy", "nosher@gmail.com", "9499926165",
                        "Tustin Avenue", "Tustin", 93833, OrganizationTypes.environmental));
    }

    public Organization addOrganization(Organization organization) {
        if(organization == null)
            throw new IllegalArgumentException("organization cannot be null or empty");
        return organization;
    }
}
