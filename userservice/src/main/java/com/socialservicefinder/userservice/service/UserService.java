package com.socialservicefinder.userservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;

@Service
@Component	
public class UserService {
	public List<User> getUsers(){
		return List.of(
				new User(1, "John Doe", "tirththakkar51@gmail.com", LocalDate.of(1997, 4, 23), "9499926165",
						"3801 Parkview Ln, Apt 24C", "Irvine", 92612, List.of(OrganizationTypes.environmental)),
				new User(2, "Jane Doe", "pvsoni@uci.edu", LocalDate.of(1998, 12, 12), "9499926165",
						"3801 Parkview Ln, Apt 24C", "Irvine", 92612, List.of(OrganizationTypes.oldage)),
				new User(3, "June Doe", "tatsatp@uci.edu", LocalDate.of(1987, 7, 8), "9499926165",
						"3801 Parkview Ln, Apt 24C", "Irvine", 92612,
						List.of(OrganizationTypes.environmental, OrganizationTypes.oldage)),
				new User(4, "Jack Doe", "vanshp1@uci.edu", LocalDate.of(1997, 1, 1), "9499926165",
						"3801 Parkview Ln, Apt 24C", "Irvine", 92612, List.of()));
	}
	
	public User addUser(User user) {
		if(user == null)
			throw new IllegalArgumentException("user cannot be null or empty");
		return user;
	}
}
