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
