package com.learn.messenger.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyServiceTest {

    @Mock
    private ExternalService externalService;

    @InjectMocks
    private MyService myService;

    @BeforeEach
    void setUp() {
        when(externalService.getExternalMessage()).thenReturn("Mocked External Message");
    }

    @Test
    @DisplayName("Test Greeting Message")
    void testGreet() {
        String result = myService.greet("John");
        assertEquals("Hello, John! Mocked External Message", result);
    }
}