package com.nitin.mockito.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.nitin.mockito.data.api.SomeService;

//Notice that the SomeService Interface is not implemented
public class BusinessImplementationBasedOnSomeService {
	
	private SomeService someService;
	
	//Constructor Injection
	public BusinessImplementationBasedOnSomeService(SomeService someService) {
		super();
		this.someService = someService;
	}

	public List<String> filteredStringsBasedOnArgument(String arg){
		List<String> filteredStrings = new ArrayList<String>();
		
 		filteredStrings = someService.retrieveStringsFromDbOrService()
				.stream()
				//.filter(Objects::isNull)
				.filter(str -> StringUtils.contains(str,arg))
				.collect(Collectors.toList());
		
		return filteredStrings; 
	}
}
