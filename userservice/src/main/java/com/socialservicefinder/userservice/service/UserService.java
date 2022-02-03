package com.socialservicefinder.userservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.repository.UserRepository;

@Service
@Component	
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User addUser(User user) {
		if(user == null)
			throw new IllegalArgumentException("user cannot be null or empty");
		return user;
	}
}
