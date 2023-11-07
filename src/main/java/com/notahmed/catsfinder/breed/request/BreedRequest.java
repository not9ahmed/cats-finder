package com.notahmed.catsfinder.breed.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public record BreedRequest(
        @Id
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String description,
        ArrayList<String> images
) {}
