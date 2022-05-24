package com.socialservicefinder.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialservicefinder.userservice.dto.OrganizationTypes;
import com.socialservicefinder.userservice.dto.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserserviceApplicationIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/v1/user")).andExpect(status().isOk());
    }

    @Test
    public void post_endpoint_should_return_ok() throws Exception {
        User user = new User("Jack Doe", "jackdoe@gmail.com", null, "999-999-9999",
                "Univesity of California, Irvine", "Irvine", "demopass", 92612,
                List.of(OrganizationTypes.environmental), false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        this.mockMvc.perform(
                        post("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void post_endpoint_null_name_should_return_badRequest() throws Exception {
        User user = new User(null, "jackdoe@gmail.com", null, "999-999-9999",
                "Univesity of California, Irvine", "Irvine", "demopass", 92612,
                List.of(OrganizationTypes.environmental), false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        this.mockMvc.perform(
                        post("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_endpoint_null_email_should_return_badRequest() throws Exception {
        User user = new User("Jack doe", null, null, "999-999-9999",
                "Univesity of California, Irvine", "Irvine", "demopass", 92612,
                List.of(OrganizationTypes.environmental), false);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        this.mockMvc.perform(
                        post("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(json).characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());
    }
}
