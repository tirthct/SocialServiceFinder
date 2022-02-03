package com.socialservicefinder.userservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.repository.UserRepository;

@SpringBootApplication
public class UserserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
}
