# Mockito-Junit-Learning

Class BusinessImplementationBasedOnSomeService is SUT (System Under Test)

Class SomeService is Dependency (which is mocked). Mocked service is actually tested, but the method that takes the mock in, gets tested.

 
### Argumnent Matchers
any() - be generic always, by passing all the arguments as arg matchers 
or be specific