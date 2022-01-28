package com.socialservicefinder.organizationservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialservicefinder.organizationservice.dto.OrganizationTypes;
import com.socialservicefinder.organizationservice.dto.Organization;

@SpringBootApplication
@RestController
public class OrganizationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationserviceApplication.class, args);
	}

	@GetMapping
	public List<Organization> Hello() {
		return List.of(new Organization(1, "NVM", "help@vnvm.com", "7234733633",
				"Irvine Spectrum plaza", "Irvine", 92656, OrganizationTypes.environmental));
	}

}
