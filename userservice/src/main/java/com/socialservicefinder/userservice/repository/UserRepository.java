package com.socialservicefinder.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialservicefinder.userservice.dto.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, Long>{
	
}
