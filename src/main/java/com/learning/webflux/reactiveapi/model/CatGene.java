package com.learning.webflux.reactiveapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CatGene {

    // "key" V2 CNT 01 10.0 F dates
    // "key" V1 CAR 01 9.0 F dates

    // firstGen longhair Main Coon 1994
    // secondGen longhair Main Coon 2000

    // Given a first and second gen longhair main coon is present
    // When they both exist
    // Filter out the second gen record

    long id; //accountKey
    String generation; //View type
    String furType; //RT - short, medium, long, curly, floofy
    String breed; //RSN
    long biscuitsPerHour; //APR
    Date identified; //Date
}
