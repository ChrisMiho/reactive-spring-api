package com.learning.webflux.reactiveapi.service;

import com.learning.webflux.reactiveapi.engine.Engine;
import com.learning.webflux.reactiveapi.model.CatGene;
import com.learning.webflux.reactiveapi.repository.ReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Component
public class ReactiveService {

    public static final String FIRST_GEN = "firstGen";
    public static final String SECOND_GEN = "secondGen";
    public static final String THIRD_GEN = "thirdGen";
    public static final String FOURTH_GEN = "fourthGen";
    @Autowired
    Engine engine;

    @Autowired
    ReactiveRepository reactiveRepository;

    public Mono<String> computeMessage() {
        return Mono.just("Hello World")
                .delayElement(Duration.ofSeconds(2));
    }

    //onSubscribe([Fuseable] FluxPeekFuseable.PeekFuseableSubscriber)
    public Mono<List<CatGene>> retrieveGenesResponse() {
        return reactiveRepository.retrieveGenes().cache()
                .flatMap(this::filterList);
    }

    private Mono<List<CatGene>> filterList(List<CatGene> catGenes) {
        return Mono.just(catGenes.stream().filter(gene -> FIRST_GEN.equals(gene.getGeneration())).toList());
    }


    //onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
    public Mono<List<CatGene>> retrieveEngineResponse() {
        return engine.geneProcessor(reactiveRepository.retrieveGenes().cache());
    }

//    private Map<String, List<CatGene>> mapOfMaps(List<CatGene> catGenes) {
//        Map<String, List<CatGene>> masterMap = new HashMap<>();
//
//        for (CatGene gene : catGenes) {
//            masterMap.computeIfAbsent(gene.getGeneration(),
//                    g -> new ArrayList<>()).add(gene);
//        }
//        return masterMap;
//    }
}
