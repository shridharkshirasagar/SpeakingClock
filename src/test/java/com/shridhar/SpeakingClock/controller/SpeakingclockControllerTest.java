package com.shridhar.SpeakingClock.controller;

import com.shridhar.SpeakingClock.service.SpeakingclockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class SpeakingclockControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SpeakingclockService speakingclockService;
    @Test
    void getTime() throws Exception {
        when(speakingclockService.timeINWords()).thenReturn("It's thirteen forty seven");
        MvcResult mvcResult = mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept("application/json")).andExpect(status().isOk()).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        response.equals("It's thirteen forty seven");

    }
    @Test
    void getTime1() throws Exception {
        when(speakingclockService.timeINWords()).thenReturn("Time format is invalid unable to process the request");
        MvcResult mvcResult = mockMvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept("application/json")).andExpect(status().isOk()).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        response.equals("Time format is invalid unable to process the request");
    }
}