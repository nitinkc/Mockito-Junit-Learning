package com.learn.messenger.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class CalculatorTest {
    @InjectMocks
    private Calculator calculator;  // It is typically used in unit tests when you want to mock the dependencies of the class under test.
    @Autowired
    MyService myService;//Spring injects the dependency into the field or constructor of the class.
    // This is commonly used in integration tests or when you are testing Spring components that rely on other Spring-managed beans.
    @Mock
    private SomeDependency someDependency;  // Mocking a dependency for unit testing
    @Mock
    private SomeDependencyImpl someDependencyImpl;  // Mocking a dependency for unit testing

    @Captor
    private ArgumentCaptor<String> dataCaptor;

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
    @NullSource	// pass a null value
    void parameterizedTest(Integer value) {
        if (null != value) {
            Integer result = calculator.add(value, 4);
            assertEquals(value + 4, result, "Parameterized addition test failed");//The message will be printed when the assertion fails,
        } else {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                calculator.add(value, 4);
            });

        }
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
        someDependency.someMethod();
        someDependency.someMethod();

        verify(someDependency, atLeastOnce()).someMethod();
        verify(someDependency, atLeast(2)).someMethod();
        verify(someDependency, atMost(3)).someMethod();
        verify(someDependencyImpl, never()).verifyMethod();
        verify(someDependency, times(3)).someMethod();
    }

    @Test
    void springIntegrationTest() {
        // Integration test using the Spring context
        String result = myService.greet("John Doe");
        assertEquals("Hello, John Doe!", result, "Integration test failed");
    }
}
