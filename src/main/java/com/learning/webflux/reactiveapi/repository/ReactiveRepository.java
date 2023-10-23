package com.learning.webflux.reactiveapi.repository;

import com.learning.webflux.reactiveapi.model.CatGene;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ReactiveRepository {

    public static final String FIRST_GEN = "firstGen";
    public static final String SECOND_GEN = "secondGen";
    public static final String THIRD_GEN = "thirdGen";
    public static final String FOURTH_GEN = "fourthGen";


    public Mono<List<CatGene>> retrieveGenes() {
        return Mono.just(Arrays.asList(
                new CatGene(1L,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FIRST_GEN,
                        "longhair",
                        "Main Coon",
                        1000L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        SECOND_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        THIRD_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now())),
                new CatGene(1L,
                        FOURTH_GEN,
                        "longhair",
                        "Main Coon",
                        1250L,
                        Date.from(Instant.now()))
        )).delayElement(Duration.ofSeconds(5));
    }
}
