package com.socialservicefinder.userservice.repository;

import com.socialservicefinder.userservice.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long>{
	
}
