package com.socialservicefinder.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.dto.UserEntity;
import com.socialservicefinder.userservice.exceptions.InvalidUserException;
import com.socialservicefinder.userservice.repository.UserRepository;

@Service
@Component
public class UserService {

	private final UserRepository userRepository;
	private final NextSequenceService nextSequenceService;
	private final Codec codec;

	@Autowired
	public UserService(UserRepository userRepository, NextSequenceService nextSequenceService) throws Exception {
		this.userRepository = userRepository;
		this.nextSequenceService = nextSequenceService;
		this.codec = new Codec();
	}

	public List<User> getUsers() {
		List<UserEntity> entities = userRepository.findAll();
		List<User> dtos = new ArrayList<>();
		for (UserEntity entity : entities) {
			dtos.add(mapToDto(entity));
		}
		return dtos;
	}

	public void addUser(User user) {
		if (user == null || user.getEmail() == null || user.getName() == null || user.getPassword() == null)
			throw new InvalidUserException("user or email or name or password cannot be null or empty");

		user.setPassword(codec.encrypt(user.getPassword()));
		var id = nextSequenceService.getNextSequence("customSequences");
		var entity = mapToEntity(user, id);
		userRepository.insert(entity);
	}

	private static User mapToDto(UserEntity entity) {
		return new User(entity.getName(), entity.getEmail(), entity.getDob(), entity.getPhoneNo(), entity.getAddress(),
				entity.getCity(), entity.getPassword(), entity.getPinCode(), entity.getPreferences());
	}

	private static UserEntity mapToEntity(User user, long id) {
		return new UserEntity(id, user.getName(), user.getEmail(), user.getDob(), user.getPhoneNo(), user.getAddress(),
				user.getCity(), user.getPassword(), user.getPinCode(), user.getPreferences());
	}
}
