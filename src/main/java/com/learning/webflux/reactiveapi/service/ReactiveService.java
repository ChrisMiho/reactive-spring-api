package com.learning.webflux.reactiveapi.service;

import com.learning.webflux.reactiveapi.engine.Engine;
import com.learning.webflux.reactiveapi.model.CatGene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class ReactiveService {

    public static final String FIRST_GEN = "firstGen";
    public static final String SECOND_GEN = "secondGen";
    public static final String THIRD_GEN = "thirdGen";
    public static final String FOURTH_GEN = "fourthGen";
    @Autowired
    Engine engine;

//    public Mono<ReactiveResponse> computeMessage() {
//        return Mono.just("Hello World")
//                .delayElement(Duration.ofSeconds(2))
//                .map(m -> new ReactiveResponse(m.toString()));
//    }

    //onSubscribe([Fuseable] FluxPeekFuseable.PeekFuseableSubscriber)
    public Mono<List<CatGene>> retrieveGenesResponse() {
        return retrieveGenes().cache()
                .flatMap(this::filterList);
    }

    private Mono<List<CatGene>> filterList(List<CatGene> catGenes) {
        return Mono.just(catGenes.stream().filter(gene -> FIRST_GEN.equals(gene.getGeneration())).toList());
    }


    //onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
    public Mono<List<CatGene>> retrieveEngineResponse() {
        return engine.geneProcessor(retrieveGenes().cache());
    }

//    private Mono<List<CatGene>> filterList2(List<CatGene> catGenes, String filter) {
////        return catGenes.map(list -> list.stream().filter(catGene -> FIRST_GEN.equals(catGene.getGeneration())).toList());
//        return Mono.from(retrieveGenes());
//    }


//    private Map<String, List<CatGene>> mapOfMaps(List<CatGene> catGenes) {
//        Map<String, List<CatGene>> masterMap = new HashMap<>();
//
//        for (CatGene gene : catGenes) {
//            masterMap.computeIfAbsent(gene.getGeneration(),
//                    g -> new ArrayList<>()).add(gene);
//        }
//        return masterMap;
//    }

    private Mono<List<CatGene>> retrieveGenes() {
        return Mono.just(Arrays.asList(
                new CatGene(1l,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now())),
                new CatGene(1l,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250l, 
                        Date.from(Instant.now()))
        )).delayElement(Duration.ofSeconds(5));
    }
}
