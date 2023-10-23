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
    long id;
    String generation;
    String furType;
    String breed;
    long biscuitsPerHour;
    Date identified;
}
