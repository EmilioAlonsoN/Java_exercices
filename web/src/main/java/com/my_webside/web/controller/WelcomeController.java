package com.my_webside.web.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class WelcomeController {

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot.......";
    }


}
