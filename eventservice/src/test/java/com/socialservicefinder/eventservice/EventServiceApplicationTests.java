package com.socialservicefinder.eventservice;

import com.socialservicefinder.eventservice.dto.Event;
import com.socialservicefinder.eventservice.service.EventService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EventServiceApplication.class})
class EventServiceApplicationTests {
    private static List<Event> _events;
    @Autowired
    private EventService eventService;

    @BeforeEach
    public void init() {
        _events = List.of(
                new Event("Covid Campaign", "Campaign to raise covid awareness", "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 10000, 92612),
                new Event("Covid Campaign - I", "Campaign I to raise covid awareness", "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 50000, 92612),
                new Event("Covid Campaign - II", "Campaign II to raise covid awareness", "9499926609", "3901 Parkview Ln, Apt 8A", "Irvine", 5000, 92613),
                new Event("Covid Campaign - III", "Campaign III to raise covid awareness", "9499926610", "3901 Parkview Ln, Apt 8A", "Irvine", 45000, 92614));
    }

    @Test
    public void getUsers() {
        Mockito.when(eventService.getEvents()).thenReturn(_events);
        List<Event> events = eventService.getEvents();
        Assertions.assertEquals(events, _events);
    }
}