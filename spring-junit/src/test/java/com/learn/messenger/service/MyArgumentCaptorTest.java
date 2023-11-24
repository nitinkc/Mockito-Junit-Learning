package com.learn.messenger.service;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class MyArgumentCaptorTest {

    @Mock private MyService myService;
    @InjectMocks private MyComponent myComponent;
    @Captor private ArgumentCaptor<String> dataCaptor;

    @Test
    void testProcessData() {
        // Initialize the mocks and inject them into the test instance
        MockitoAnnotations.openMocks(this);

        // Call the method you want to test
        myComponent.processData("Test Data");

        // Use the ArgumentCaptor to capture the argument passed to myService.process
        verify(myService).process(dataCaptor.capture());

        // Assert that the captured argument is what you expect
        String capturedData = dataCaptor.getValue();
        assertEquals("Test Data", capturedData);
    }
}