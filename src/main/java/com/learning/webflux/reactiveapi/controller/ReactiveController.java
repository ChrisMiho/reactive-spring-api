package com.learning.webflux.reactiveapi.controller;

import com.learning.webflux.reactiveapi.model.ReactiveResponse;
import com.learning.webflux.reactiveapi.service.ReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

    @Autowired
    ReactiveService reactiveService;

//    @GetMapping("/demo")
//    public Mono<ReactiveResponse> demo() {
//        return reactiveService.computeMessage().log();
//    }

    @GetMapping("/userId")
    public Mono<ReactiveResponse> getUser() {
        return reactiveService.retrieveGenesResponse().log();
    }

}
