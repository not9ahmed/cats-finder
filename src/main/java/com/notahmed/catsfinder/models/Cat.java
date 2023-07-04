package com.notahmed.catsfinder.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Table("Cat")
public record Cat (
        @Id
        Long id,
        String name,

//        will reference breed table
//        AggregateReference <Breed, Long> breed_id,

//        will reference user table
//        AggregateReference <User, Long> owner_id,


        Integer breed_id,

        Integer owner_id,

        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys
){
}

/*
* CREATE TABLE IF NOT EXISTS "Cat" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    breed_id INTEGER NOT NULL,
    owner_id INTEGER NOT NULL,
    birth_date DATE,
    images VARCHAR(200)[],
    toys VARCHAR(30)[]
);
* */