package com.learn.messenger.controller;

import com.learn.messenger.service.MyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MyController.class)
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyService myService;  // MyService is a component that MyController depends on

    @Test
    void testControllerEndpoint() throws Exception {
        // Mock the behavior of the service
        when(myService.greet(anyString())).thenReturn("Hello , John Doe!");

        // Perform the HTTP GET request to the controller endpoint
        mockMvc.perform(get("/api/greeting?name=John%20Doe"))
                .andExpect(status().isOk());  // Assuming the endpoint returns HTTP 200

        // Verifying that the service method was called
        verify(myService).greet(anyString());
    }
}
