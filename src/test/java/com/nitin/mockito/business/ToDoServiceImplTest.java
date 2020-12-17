package com.nitin.mockito.business;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.nitin.mockito.data.api.ToDoService;

import junit.framework.Assert;

public class ToDoServiceImplTest {

	@Test
	public void testToDoFiltered_Mockito() {
		ToDoService toDoServiceMock = Mockito.mock(ToDoService.class);
		
		List<String> todos = Arrays.asList("Spring Revisions","Spring Transactions","GCP","Angualr");
		
		//Using Interface, Mock the external Service
		Mockito.when(toDoServiceMock.retrieveToDo("dummyUser")).thenReturn(todos);
		
		ToDoServiceImpl toDoServiceImpl = new ToDoServiceImpl(toDoServiceMock);
		
		List<String> filteredTodos = toDoServiceImpl.toDoFiltered("dummyUser");
		
		Assert.assertEquals(2,filteredTodos.size());
			
	}

}
