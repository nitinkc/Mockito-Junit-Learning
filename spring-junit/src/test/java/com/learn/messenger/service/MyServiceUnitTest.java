package com.learn.messenger.service;

import com.learn.messenger.controller.MyController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyServiceUnitTest {

    //The @Mock annotation is used to create mock objects for the dependencies of the class being tested.
    // Mock objects simulate the behavior of real objects but don't have actual implementations.
    @Mock private ExternalService externalService;

    //@InjectMocks is applied to the class that you want to test.
    // It tells the testing framework to inject the mock objects created with
    //@Mock into the appropriate places within the class under test.
    @InjectMocks private MyService myService;

    private MyController myController;

    @BeforeEach
    void setUp() {
        myController = new MyController(myService);//Maual initialization of non Mocks

        MockitoAnnotations.initMocks(this);//Initialyze all the Mocks
        when(externalService.getExternalMessage()).thenReturn("Mocked External Message");
    }

    @Test
    @DisplayName("Test Greeting Message")
    void testGreet() {
        String result = myService.greetExternalService("John");
        assertEquals("Hello, John! Mocked External Message", result);
    }
}