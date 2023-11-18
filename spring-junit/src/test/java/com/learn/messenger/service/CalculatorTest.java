package com.learn.messenger.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CalculatorTest {

    @Autowired
    private Calculator calculator;  // Spring autowired for integration testing

    @Mock
    private SomeDependency someDependency;  // Mocking a dependency for unit testing

    @BeforeEach
    void setUp() {
        // Setup logic before each test method
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown() {
        // Teardown logic after each test method
        System.out.println("After each test");
    }

    @Test
    @DisplayName("JUnit 5 Test - Addition")
    void testAdd() {
        int result = calculator.add(3, 7);
        assertEquals(10, result, "Addition result should be 10");
    }

    @Test
    @DisplayName("JUnit 5 Test - Subtraction")
    void testSubtract() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "Subtraction result should be 5");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int value) {
        int result = calculator.add(value, 5);
        assertEquals(value + 5, result, "Parameterized addition test failed");
    }

    @RepeatedTest(3)
    void repeatedTest() {
        int result = calculator.subtract(20, 5);
        assertEquals(15, result, "Repeated subtraction test failed");
    }

    @Test
    @Tag("slow")
    void slowTest() {
        int result = calculator.add(10, 20);
        assertEquals(30, result, "Slow test failed");
    }

    @Test
    @Disabled("Disabled test")
    void disabledTest() {
        // This test will be disabled
        fail("This test should not run");
    }

    @MockitoSettings(strictness = Strictness.LENIENT)
    @Test
    void lenientMockingTest() {
        when(someDependency.someMethod()).thenReturn("Mocked result");
        String result = someDependency.someMethod();
        assertEquals("Mocked result", result, "Lenient mocking test failed");
    }

    @Test
    void verificationModeTest() {
        someDependency.someMethod();
        verify(someDependency, times(1)).someMethod();
    }

    @Test
    void integrationTest() {
        // Integration test using the Spring context
        int result = calculator.add(5, 5);
        assertEquals(10, result, "Integration test failed");
    }
}
