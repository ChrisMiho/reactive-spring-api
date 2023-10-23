package com.learning.webflux.reactiveapi.controller;

import com.learning.webflux.reactiveapi.model.CatGene;
import com.learning.webflux.reactiveapi.service.ReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ReactiveController {

    @Autowired
    ReactiveService reactiveService;

    @GetMapping("/demo")
    public Mono<String> demo() {
        return reactiveService.computeMessage().log();
    }

    @GetMapping("/getV1")
    public Mono<List<CatGene>> getFirst() {

        return reactiveService.retrieveGenesResponse().log();
    }

    @GetMapping("/getEngine")
    public Mono<List<CatGene>> getEngine() {

        return reactiveService.retrieveEngineResponse().log();
    }

}
