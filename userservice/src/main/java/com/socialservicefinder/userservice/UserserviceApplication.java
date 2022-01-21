package com.socialservicefinder.userservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;

@SpringBootApplication
@RestController
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@GetMapping
	public List<User> Hello() {
		return List.of(new User(1, "Tirth Chetan", "tirththakkar51@gmail.com", LocalDate.of(1997, 4, 23), "9499926165",
				"3801 Parkview Ln, Apt 24C", "Irvine", 92612, List.of(OrganizationTypes.environmental)));
	}

}
