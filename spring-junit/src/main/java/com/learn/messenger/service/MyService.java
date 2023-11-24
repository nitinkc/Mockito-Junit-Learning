package com.learn.messenger.service;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class MyService {
    private ExternalService externalService;

    @Autowired
    public MyService(ExternalService externalService){
        this.externalService = externalService;
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public String greetExternalService(String name) {
        return "Hello, " + name + "! " + externalService.getExternalMessage();
    }
    public String getValue() {
        // Some complex logic here
        return "Real Value";
    }

    public String getAnotherValue() {
        // Some other logic here
        return "Real Another Value";
    }

    void process(String data){
        System.out.println(data);
    }

}
