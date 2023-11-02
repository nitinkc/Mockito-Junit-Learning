# Mockito-Junit-Learning

Class BusinessImplementationBasedOnSomeService is SUT (System Under Test)

Class SomeService is Dependency (which is mocked). Mocked service is actually tested, but the method that takes the mock in, gets tested.

 
### Argumnent Matchers
any() - be generic always, by passing all the arguments as arg matchers 
or be specific



#### Step 1

Class level annotations

```java
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
```


#### Declaring the Mocks
```java
ReportsBigQueryService reportsBigQueryServiceMock = Mockito.mock(ReportsBigQueryService.class);
```
OR

Prefer this way

```java
@Mock
private YourDataAccessObject dataAccessObjectMock;

@InjectMocks
private YourService yourServiceUnderTest;

//Initialize the Mocks
@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
}
```


# Common Errors

1. **DO NOT** use the argument Matchers on SUT, or injectableMocks
```java
// Call the method under test
List<Map<String, Object>> result = yourServiceUnderTest.getDataById(anyString(), "sample", "facility");
```

```log
org.mockito.exceptions.misusing.InvalidUseOfMatchersException: 
Invalid use of argument matchers!
```

Use Argument matchers only on the Mocks

```java
 // Mocking the behavior of reportsBigQueryService
List<Map<String, Object>> mockDBCall = dataAccessObjectMock.getRecordFromView(anyString(), anyString(), any());
when(mockDBCall).thenReturn(data);//mockDBCall == data initialized in @BeforeEach void setUp()
```


argument might not match exactly with the one used when the getRecordFromView method is called in your code. Mockito uses argument matching to determine which method behavior to mock based on the arguments provided.

when you are providing specific arguments

Mockito will only match the `when` statement when these exact arguments are used in the actual method call. If the actual method call uses different instances of the parameters object, for example, the when statement won't match, and the mock won't be triggered.


You are using anyString() and any() as argument matchers. These matchers are more lenient and will match any argument of the specified type. In this case, Mockito will match the when statement for any combination of strings and any object, so it will return mockData for any method call to getRecordFromView.

@MockitoSettings(strictness = Strictness.LENIENT)


To test the exceoption

// Call the method under test
FutureException exception = org.junit.jupiter.api.Assertions.assertThrows(FutureException.class, () -> {
idtRoundingQueryService.getOptionsData("facility123");
});