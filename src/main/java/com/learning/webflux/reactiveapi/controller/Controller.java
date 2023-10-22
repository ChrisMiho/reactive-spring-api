package com.learning.webflux.reactiveapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class Controller {

    //Service

    @GetMapping("/userId")
    public Mono<String> getUser() {
        return computeMessage().log();
    }

    private Mono<String> computeMessage() {
        return Mono.just("Hello World").delayElement(Duration.ofSeconds(5));
    }


}
