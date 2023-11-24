package com.learn.messenger.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

//@ExtendWith(MockitoExtension.class)
public class MySpyTest {
    @Spy private MyService myService;//If not Stubbed, the real method is called

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);//Initialyze all the Mocks/Spy
    }

    @Test
    void testGetValue() {
        // You can stub specific methods if needed
        doReturn("Mocked Value").when(myService).getValue();

        // The real logic of getAnotherValue() is executed
        String result = myService.getAnotherValue();
        assertEquals("Real Another Value", result);

        // The getValue() method is stubbed to return "Mocked Value"
        String mockedResult = myService.getValue();
        assertEquals("Mocked Value", mockedResult);
    }
}
