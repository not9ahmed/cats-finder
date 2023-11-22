package com.notahmed.catsfinder.breed;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Objects;

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


// Updated Breed
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

/*
@Table("Breed")
public class Breed {
        @Id
        private Long id;
        @NotBlank
        private String name;
        private String description;
        private ArrayList<String> images;
        private String country;

        // long text
        private String history;

        // array list or mappedCollection
        private ArrayList<String> characteristics;
        private ArrayList<String> funFacts;



}

 */