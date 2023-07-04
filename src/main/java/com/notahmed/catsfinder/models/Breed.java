package com.notahmed.catsfinder.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;

@Table("Breed")
public record Breed (
    @Id
    Long id,
    String name,
    String description,
    ArrayList<String> images
){}


/*
* CREATE TABLE IF NOT EXISTS "Breed" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    images VARCHAR(200)[]
);
* */