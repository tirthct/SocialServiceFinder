package com.socialservicefinder.eventservice;

import com.socialservicefinder.eventservice.service.EventService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class EventServiceApplicationTestConfiguration {
    @Bean
    @Primary
    public EventService nameService() {
        return Mockito.mock(EventService.class);
    }
}
