package com.socialservicefinder.userservice.controller;

import java.util.List;

import com.socialservicefinder.userservice.dto.Login;
import com.socialservicefinder.userservice.exceptions.InvalidLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.exceptions.InvalidUserException;
import com.socialservicefinder.userservice.service.UserService;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@PostMapping("/login")
	public ResponseEntity<User> authUser(@RequestBody Login login){
		try{
			var user = userService.getAuthUser(login);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		catch (InvalidLoginException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		catch (InvalidUserException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}



}

