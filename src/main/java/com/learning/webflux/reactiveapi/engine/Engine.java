package com.learning.webflux.reactiveapi.engine;

import com.learning.webflux.reactiveapi.model.CatGene;
import lombok.Getter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class Engine {

    @Getter
    private enum Generations {
        FIRST_GEN("firstGen"),
        SECOND_GEN("secondGen"),
        THIRD_GEN("thirdGen"),
        FOURTH_GEN("fourthGen");

        // Field to hold additional info about the season
        private final String generation;

        Generations(String inGen) {
            this.generation = inGen;
        }

    }

    //Too much mono
    public Mono<List<CatGene>> geneProcessor(Mono<List<CatGene>> catGenes) {
        return getGeneration(catGenes, Generations.FIRST_GEN)
                .zipWith(getGeneration(catGenes, Generations.THIRD_GEN),
                        (first, third) ->
                                Stream.concat(first.stream(), third.stream()).toList()).log();
    }

    //Too much mono
    private Mono<List<CatGene>> getGeneration(Mono<List<CatGene>> catGenes, Generations inputGen) {
        return catGenes.flatMap(list -> {
            return filterList(inputGen.getGeneration(), list).log();
        });
    }

    //Too much mono
    private Mono<List<CatGene>> filterList(String generation, List<CatGene> catGenes) {
        return Mono.just(catGenes.stream()
                .filter(catGene -> generation.equals(catGene.getGeneration()))
                .collect(Collectors.toList())).log();
    }
}
