package com.medium.actuator.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final MeterRegistry meterRegistry;

    @GetMapping("/greeting")
    public String greeting() throws InterruptedException {
        Timer.Sample sample = Timer.start(meterRegistry);
        // Sleep between 0s and 5s
        Thread.sleep((long) (Math.random() * 5000));

        sample.stop(meterRegistry.timer("request.greeting", "env", "local"));
        return "Hello From Spring Boot App !";
    }
}
