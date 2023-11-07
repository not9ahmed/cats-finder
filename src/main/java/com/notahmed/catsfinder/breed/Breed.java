package com.notahmed.catsfinder.breed;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;

// same as before
// Using class for the models is better
// TODO I can find more details about breed such as
//  -- origin country
// -- history
// -- characteristics
// -- facts which is a list
// -- other names
@Table("Breed")
public record Breed (
        @Id
        Long id,
        @NotBlank
        String name,
        String description,
        ArrayList<String> images
){}


// Updates Breed
/*
@Table("Breed")
public record Breed (
        @Id
        Long id,
        @NotBlank
        String name,
        String description,
        ArrayList<String> images,
        String originCountry
        String history,

        // array list or mappedCollection
        ArrayList<String> characteristics,
        ArrayList<String> funFacts
){}
 */