package com.nitin.mockito.BDD;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.nitin.mockito.business.BusinessImplementationBasedOnSomeService;
import com.nitin.mockito.data.api.SomeService;


public class GivenWhenThen {

	@Test
	public void test() {
		// Given - Setup
		SomeService someServiceMock = Mockito.mock(SomeService.class);
		List<String> someStrings = Arrays.asList("Spring Revisions", "Spring Transactions", "GCP", "Angualr");
		
		// when...then return OR given...willReturn
		
		when(someServiceMock.retrieveStringsFromDbOrService()).thenReturn(someStrings);

		//WHEN (searched with an specific keyword, then return filtered list)
		BusinessImplementationBasedOnSomeService serviceImpl = new BusinessImplementationBasedOnSomeService(someServiceMock);
		List<String> filteredTodos = serviceImpl.filteredStringsBasedOnArgument("Spring");

		//THEN
		assertEquals(2, filteredTodos.size());
	}

}
