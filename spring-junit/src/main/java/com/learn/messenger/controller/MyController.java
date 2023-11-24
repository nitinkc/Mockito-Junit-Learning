package com.learn.messenger.controller;

import com.learn.messenger.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam String name) {
        // Delegates the work to a service class
        return myService.greet(name);
    }
}