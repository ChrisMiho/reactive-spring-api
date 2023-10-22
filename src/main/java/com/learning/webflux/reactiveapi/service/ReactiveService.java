package com.learning.webflux.reactiveapi.service;

import com.learning.webflux.reactiveapi.model.CatGene;
import com.learning.webflux.reactiveapi.model.ReactiveResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Component
public class ReactiveService {

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

    public Mono<ReactiveResponse> retrieveGenesResponse(){
        return retrieveGenes()
                .flatMap(list -> filterList(list)).log()
                .map(listed -> new ReactiveResponse(listed)).log();
//        return retrieveGenes()
//                .flatMap(list -> filterList(list))
//                .flatMap(filteredList -> new );
    }

    private Mono<List<CatGene>> filterList(List<CatGene> catGenes) {
        return Mono.just(catGenes.stream().filter(gene -> "firstGen".equals(gene.getGeneration())).toList());
    }

    private Mono<List<CatGene>> filterList2(List<CatGene> catGenes) {
        return Mono.just(catGenes.stream().filter(gene -> "firstGen".equals(gene.getGeneration())).toList());
    }

//    private Map<String, List<CatGene>> mapOfMaps(List<CatGene> catGenes){
//        Map<String, List<CatGene>> firstGen = new HashMap<>();
//        Map<String, List<CatGene>> secondGen = new HashMap<>();
//
//        for(CatGene gene : catGenes){
//            if("secondGen".equals(gene.getGeneration())){
//                secondGen.put(gene.getId(), gene);
//            }
//        }
//
//        return null;
//
//    }

    private Mono<List<CatGene>> retrieveGenes() {
        return Mono.just(Arrays.asList(
                new CatGene(1l, // accountKey
                        "firstGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1000l, //APR
                        Date.from(Instant.now())),
                new CatGene(1l, // accountKey
                        "secondGen", //viewType
                        "longhair", // RT - long hair
                        "Main Coon", //RSN
                        1250l, //APR
                        Date.from(Instant.now()))
        )).delayElement(Duration.ofSeconds(3));
    }
}
