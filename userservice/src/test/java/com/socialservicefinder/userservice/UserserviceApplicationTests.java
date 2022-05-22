package com.socialservicefinder.userservice;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.service.UserService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserserviceApplication.class})
class UserserviceApplicationTests {

    private static List<User> _users;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init() {
        _users = List.of(
                new User("John Doe", "johndoe@gmail.com", LocalDate.of(2000, 10, 10),
                        "999-999-9999", "Univesity of California, Irvine", "Irvine",
                        "demopass", 92612, List.of(OrganizationTypes.environmental), false),
                new User("Jane Doe", "janedoe@gmail.com", LocalDate.of(2005, 5, 1),
                        "999-999-9998", "Univesity of California, Los Angeles", "Los Angeles",
                        "demopass", 99999, List.of(OrganizationTypes.oldage), false),
                new User("June Doe", "junedoe@gmail.com", LocalDate.of(1985, 12, 30),
                        "999-999-9997", "Univesity of California, San Diego", "San Diego",
                        "demopass", 88888, List.of(OrganizationTypes.environmental,
                        OrganizationTypes.orphanage), false),
                new User("Jake Doe", "jakedoe@gmail.com", LocalDate.of(2000, 10, 10),
                        "999-999-9996", "Univesity of California, East Bay", "Easy Bay",
                        "demopass", 77777, List.of(), false));
    }

    @Test
    public void getUsers() {
        Mockito.when(userService.getUsers()).thenReturn(_users);
        List<User> user = userService.getUsers();
        Assertions.assertEquals(user, _users);
    }
}
