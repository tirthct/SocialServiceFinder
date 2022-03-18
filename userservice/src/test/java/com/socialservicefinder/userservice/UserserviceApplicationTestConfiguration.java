package com.socialservicefinder.userservice;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.socialservicefinder.userservice.service.UserService;

@Profile("test")
@Configuration
public class UserserviceApplicationTestConfiguration {
    @Bean
    @Primary
    public UserService nameService() {
        return Mockito.mock(UserService.class);
    }
}