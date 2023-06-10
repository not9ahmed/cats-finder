package com.notahmed.catsfinder.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Cat (
        @Id
        long id,
        String name,
        int age,
        LocalDateTime birthDate

){
}
