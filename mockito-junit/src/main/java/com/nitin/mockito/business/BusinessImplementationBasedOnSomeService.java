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

	public List<Map<String,Objects>> myMethod(String str){

		//Make a DB Call with str say for ex Last name
		List<String> namesWithSameLastName = someService.retrieveStringsFromDbOrService(str);//Mock this

		//Find the meaning of the name from MeanongFinerService with Rest Template call

		//https://run.mocky.io/v3/bbb214bf-5245-4549-9219-c016607ce75f
		//Delete: https://designer.mocky.io/manage/delete/bbb214bf-5245-4549-9219-c016607ce75f/L8K9BQSs5FK8SuXObIKgVP9GGo9v0tA4C7iY

		List<Map<String,Objects>> response = new RestTemplate.exchange();//Mock This as well.


		namesWithSameLastName.get(0)


	}
}
