package com.learn.messenger.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyIntegrationTest {

    @Autowired
    private MyService myService;

    @MockBean
    private ExternalService externalService;

    @Test
    void testGreetIntegration() {
        when(externalService.getExternalMessage()).thenReturn("Mocked External Message");
        String result = myService.greetExternalService("Jane");
        assertEquals("Hello, Jane! Mocked External Message", result);
    }
}
