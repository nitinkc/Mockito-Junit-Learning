package com.nitin.mockito.anyMatchers;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class AnyMatcherMock {

	@Test
	public void test1() {
		List listMock = mock(List.class);
		
		//without argument matcher
		when(listMock.get(0)).thenReturn("Nitin");
		
		assertEquals("Nitin", listMock.get(0));
		
		//with argument matcher
		when(listMock.get(anyInt())).thenReturn("Chaurasia");
		assertEquals("Chaurasia", listMock.get(10010));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void test2() {
		List listMock = mock(List.class);
		
		//with argument matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("meri exception"));
		
		listMock.get(0);
		
	}

}
