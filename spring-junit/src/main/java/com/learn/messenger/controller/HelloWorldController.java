package com.learn.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nitin on Thursday, January/09/2020 at 9:45 PM
 */

@RestController
public class HelloWorldController {
    @Autowired
    Environment env;

    @GetMapping("/")
    public String HelloWorldTesting(){
        String msg = "<h1>Messenger Service is Up and Running...</h1>";
        String link= "<a href=\"https://github.com/nitinkc/messenger-spring-boot/blob/master/README.md\">Visit for Exposed URI's !</a>";
        String swaggerLink = "http://localhost:"+ env.getProperty("server.port")+"/swagger-ui.html";

        String swaglink= "<p><a href="+swaggerLink+">Visit Swagger Documentation SWAGGER !</a></p>";

        return msg+link + swaglink;
    }
}
