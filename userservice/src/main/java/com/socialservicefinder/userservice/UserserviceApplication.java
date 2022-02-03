package com.socialservicefinder.userservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;

@SpringBootApplication
public class UserserviceApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.insert(new User(1, "John Doe", "johndoe@gmail.com", LocalDate.of(2022, 4, 23), "9499926165",
				"Somewhere in Cali", "Irvine", 92612, List.of(OrganizationTypes.environmental)));
		
		List<User> users = repo.findAll();
		
		
		System.out.println(users);
		
		System.out.println("Done!");
	}
}
