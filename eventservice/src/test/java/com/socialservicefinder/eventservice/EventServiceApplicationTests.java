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

import java.util.Date;
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
        Date startDate = new Date(System.currentTimeMillis() - 10000);
        Date endDate = new Date(System.currentTimeMillis());
        _events = List.of(
                new Event("Covid Campaign", "Campaign to raise covid awareness", "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 10000, 92612, "abc@gmail.com", "Covid", startDate, endDate, false),
                new Event("Covid Campaign - I", "Campaign I to raise covid awareness", "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 50000, 92612, "abc@gmail.com", "Covid", startDate, endDate, false),
                new Event("Covid Campaign - II", "Campaign II to raise covid awareness", "9499926609", "3901 Parkview Ln, Apt 8A", "Irvine", 5000, 92613, "abc@gmail.com", "Covid", startDate, endDate, false),
                new Event("Covid Campaign - III", "Campaign III to raise covid awareness", "9499926610", "3901 Parkview Ln, Apt 8A", "Irvine", 45000, 92614, "abc@gmail.com", "Covid", startDate, endDate, false));
    }

    @Test
    public void getEvents() {
        Mockito.when(eventService.getEvents()).thenReturn(_events);
        List<Event> events = eventService.getEvents();
        Assertions.assertEquals(events, _events);
    }

    @Test
    public void getMatchingEvents() {
        Mockito.when(eventService.getMatchingEvents(Mockito.anyString())).thenReturn(_events);
        List<Event> events = eventService.getMatchingEvents("Covid");
        Assertions.assertEquals(events, _events);
    }
}