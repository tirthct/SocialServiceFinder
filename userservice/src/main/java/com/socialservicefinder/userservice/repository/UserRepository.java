package com.socialservicefinder.userservice.repository;

import com.socialservicefinder.userservice.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, Long>{
    public User findUserByEmail(String email);
}
