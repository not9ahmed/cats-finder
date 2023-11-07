package com.notahmed.catsfinder.breed.response;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public record BreedResponse(
        @Id
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String description,
        ArrayList<String> images
) {
}
