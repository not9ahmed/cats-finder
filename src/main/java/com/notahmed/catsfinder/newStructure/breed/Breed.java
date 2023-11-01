package com.notahmed.catsfinder.newStructure.breed;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;

// same as before
@Table("Breed")
public record Breed (
        @Id
        Long id,
        @NotBlank
        String name,
        String description,
        ArrayList<String> images
){}
