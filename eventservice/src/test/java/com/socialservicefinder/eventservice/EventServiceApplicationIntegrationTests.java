package com.socialservicefinder.eventservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialservicefinder.eventservice.dto.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class EventServiceApplicationIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/v1/event")).andExpect(status().isOk());
    }

    @Test
    public void post_endpoint_should_return_ok() throws Exception {
        Date startDate = new Date(System.currentTimeMillis() - 10000);
        Date endDate = new Date(System.currentTimeMillis());
        Event event = new Event("Covid Campaign", "Campaign to raise covid awareness", "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 10000, 92612, "abc@gmail.com", "Covid", startDate, endDate, false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);
        this.mockMvc.perform(
                        post("/api/v1/event").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void post_endpoint_null_name_should_return_badRequest() throws Exception {
        Date startDate = new Date(System.currentTimeMillis() - 10000);
        Date endDate = new Date(System.currentTimeMillis());
        Event event = new Event(null, "Campaign to raise covid awareness", "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 10000, 92612, "abc@gmail.com", "Covid", startDate, endDate, false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);
        this.mockMvc.perform(
                        post("/api/v1/event").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_endpoint_null_description_should_return_badRequest() throws Exception {
        Date startDate = new Date(System.currentTimeMillis() - 10000);
        Date endDate = new Date(System.currentTimeMillis());
        Event event = new Event("Covid Campaign", null, "9499926608", "3901 Parkview Ln, Apt 8A", "Irvine", 10000, 92612, "abc@gmail.com", "Covid", startDate, endDate, false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);
        this.mockMvc.perform(
                        post("/api/v1/event").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_endpoint_null_address_should_return_badRequest() throws Exception {
        Date startDate = new Date(System.currentTimeMillis() - 10000);
        Date endDate = new Date(System.currentTimeMillis());
        Event event = new Event("Covid Campaign", "Campaign to raise covid awareness", "9499926608", null, "Irvine", 10000, 92612, "abc@gmail.com", "Covid", startDate, endDate, false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);
        this.mockMvc.perform(
                        post("/api/v1/event").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }
}