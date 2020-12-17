package com.nitin.mockito.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.nitin.mockito.data.api.ToDoService;


// ToDoServiceImpl is SUT (System Under Test)
// ToDoService is : Dependency
public class ToDoServiceImpl {
	
	private ToDoService toDoService;
	
	//Constructor Injection
	public ToDoServiceImpl(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	public List<String> toDoFiltered(String user){
		List<String> filteredToDos = new ArrayList<String>();
		
 		filteredToDos = toDoService.retrieveToDo(user)
				.stream()
				.filter(str -> StringUtils.contains(str,"Spring"))
				.collect(Collectors.toList());
		
		return filteredToDos;
	}
}
