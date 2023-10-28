package com.nitin.mockito.business;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nitin.mockito.data.api.SomeService;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BusinessImplementationBasedOnSomeServiceTest {

	// BusinessImplementationBasedOnSomeService is SUT (System Under Test)
	// SomeService is : Dependency (which is mocked)


	@Test
	public void testToDoFiltered_Mockito_ListWithValues() {
		SomeService someServiceMock = Mockito.mock(SomeService.class);

		List<String> someStrings = Arrays.asList("Spring Revisions", "Spring Transactions", "GCP", "Angualr");

		// Using Interface, Mock the external Service
		Mockito.when(someServiceMock.retrieveStringsFromDbOrService()).thenReturn(someStrings);

		BusinessImplementationBasedOnSomeService serviceImpl = new BusinessImplementationBasedOnSomeService(someServiceMock);

		List<String> filteredTodos = serviceImpl.filteredStringsBasedOnArgument("Spring");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void testToDoFiltered_Mockito_EmptyList() {
		SomeService toDoServiceMock = Mockito.mock(SomeService.class);

		List<String> emptyList = Arrays.asList();

		// Using Interface, Mock the external Service
		Mockito.when(toDoServiceMock.retrieveStringsFromDbOrService()).thenReturn(emptyList);

		BusinessImplementationBasedOnSomeService serviceImpl = new BusinessImplementationBasedOnSomeService(toDoServiceMock);

		List<String> filteredTodos = serviceImpl.filteredStringsBasedOnArgument("dummyFilter");

		assertEquals(0 , filteredTodos.size());
	}

}
