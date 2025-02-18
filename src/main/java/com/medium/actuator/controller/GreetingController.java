package com.medium.actuator.controller;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    @GetMapping("/greeting")
    @Timed(value = "request.greeting")
    public String greeting() throws InterruptedException {
        // Sleep between 0s and 5s
        Thread.sleep((long) (Math.random() * 5000));

        return "Hello From Spring Boot App !";
    }
}
