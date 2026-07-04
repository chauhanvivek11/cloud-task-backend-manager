package com.alight.cloudtaskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Vivek! Welcome to Java Cloud at Alight Solutions!";
    }
}
