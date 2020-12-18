package com.nitin.mockito.list;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class TestMockingList {

	@Test
	public void testListSize() {
		//Mock the java.util.List interface
		List mockList = Mockito.mock(List.class);
		
		int size = 2;
		
		//Mock list.size method and return value 2
		Mockito.when(mockList.size()).thenReturn(size);
		
		assertEquals(2,mockList.size());
		
		assertEquals(2,mockList.size());

	}
	
	@Test
	public void anyTestMethod_multipleValue() {
		//Mock the java.util.List interface
		List mockList = Mockito.mock(List.class);
		
		int size = 2;
		
		Mockito.when(mockList.size()).thenReturn(size).thenReturn(3).thenReturn(4);
		
		//Calling the first time
		assertEquals(2,mockList.size());
		
		//Calling second time
		assertEquals(3,mockList.size());
		//Calling third time
		assertEquals(4,mockList.size());
	}

}
