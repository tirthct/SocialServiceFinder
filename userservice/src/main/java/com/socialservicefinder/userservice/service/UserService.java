package com.socialservicefinder.userservice.service;

import java.util.List;

import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.exceptions.InvalidUserException;
import com.socialservicefinder.userservice.repository.UserRepository;

@Service
@Component
public class UserService {
	private final UserRepository userRepository;
	private final Codec codec;
	private final int ASSIGN_ID_TRIES;

	@Autowired
	public UserService(UserRepository userRepository) throws Exception {
		this.userRepository = userRepository;
		this.codec = new Codec();
		this.ASSIGN_ID_TRIES = 3;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public void addUser(User user) {
		if (user == null || user.getEmail() == null || user.getName() == null || user.getPassword() == null)
			throw new InvalidUserException("user or email or name or password cannot be null or empty");

		user.setPassword(codec.encrypt(user.getPassword()));
		insertUser(user);
	}

	public void insertUser(User user) {
		// Try assigning ID to organization for TRIES number of times.
		boolean id_assigned = false;
		for(int tries = 0; tries < ASSIGN_ID_TRIES; tries++){
			try{
				user.assign_id();
				userRepository.insert(user);
				id_assigned = true;
				break;
			}
			catch (MongoWriteException ignored){
			}
		}
		if(!id_assigned)
			throw new InvalidUserException("Please try after sometime.");
	}
}
