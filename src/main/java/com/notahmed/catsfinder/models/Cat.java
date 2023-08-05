package com.notahmed.catsfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

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


//        Long breed_id,
        AggregateReference<Breed, Long> breed_id,

//        Long owner_id,
        AggregateReference<User, Long> owner_id,

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