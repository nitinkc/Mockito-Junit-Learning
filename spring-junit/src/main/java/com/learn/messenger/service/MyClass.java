package com.learn.messenger.service;

import org.springframework.stereotype.Service;

@Service
public class MyClass {
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
