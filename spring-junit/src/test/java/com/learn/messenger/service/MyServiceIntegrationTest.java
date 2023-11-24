package com.learn.messenger.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyServiceIntegrationTest {

    @Autowired
    private MyService myService;

    @MockBean
    private ExternalService externalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(externalService.getExternalMessage()).thenReturn("Mocked External Message");
    }

    @Test
    void testGreetIntegration() {
        String result = myService.greetExternalService("Jane");
        assertEquals("Hello, Jane! Mocked External Message", result);
    }
}
