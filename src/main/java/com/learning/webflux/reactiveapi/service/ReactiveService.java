package com.learning.webflux.reactiveapi.service;

import com.learning.webflux.reactiveapi.engine.Engine;
import com.learning.webflux.reactiveapi.model.CatGene;
import com.learning.webflux.reactiveapi.model.ReactiveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Component
public class ReactiveService {

    @Autowired
    Engine engine;
    public static final String FIRST_GEN = "firstGen";

//    public Mono<ReactiveResponse> computeMessage() {
//        return Mono.just("Hello World")
//                .delayElement(Duration.ofSeconds(2))
//                .map(m -> new ReactiveResponse(m.toString()));
//    }
    // accountKey - id
    // View -
    // RT
    // RSN
    // APR
    // V or F

    public Mono<ReactiveResponse> retrieveGenesResponse() {
        return retrieveGenes()
                .flatMap(list -> filterList(list)).log()
                .map(listed -> new ReactiveResponse(listed)).log();
//        return retrieveGenes()
//                .flatMap(list -> filterList(list))
//                .flatMap(filteredList -> new );
    }

//    public Mono<ReactiveResponse> retrieveGenesResponse2() {
//        return Mono.from(new ReactiveResponse(
//                        retrieveGenes().flatMap(list -> engine.geneProcessor(list))
//        )
//    }

    private Mono<List<CatGene>> filterList(List<CatGene> catGenes) {
        return Mono.just(catGenes.stream().filter(gene -> FIRST_GEN.equals(gene.getGeneration())).toList());
    }

    private Mono<List<CatGene>> filterList2(List<CatGene> catGenes) {
//        return catGenes.map(list -> list.stream().filter(catGene -> FIRST_GEN.equals(catGene.getGeneration())).toList());
        return Mono.from(retrieveGenes());
    }


    private Map<String, List<CatGene>> mapOfMaps(List<CatGene> catGenes) {
        Map<String, List<CatGene>> masterMap = new HashMap<>();

        for (CatGene gene : catGenes) {
            masterMap.computeIfAbsent(gene.getGeneration(),
                    g -> new ArrayList<>()).add(gene);
        }

        return masterMap;

    }

    private Mono<List<CatGene>> retrieveGenes() {
        return Mono.just(Arrays.asList(
                new CatGene(1l, // accountKey
                        FIRST_GEN, //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1000l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "secondGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "thirdGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "fourthGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        FIRST_GEN, //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1000l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "secondGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "thirdGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "fourthGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        FIRST_GEN, //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1000l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "secondGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "thirdGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "fourthGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        FIRST_GEN, //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1000l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "secondGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "thirdGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "fourthGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now()))
        )).delayElement(Duration.ofSeconds(3));
    }
}
