package com.socialservicefinder.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialservicefinder.userservice.dto.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
}
