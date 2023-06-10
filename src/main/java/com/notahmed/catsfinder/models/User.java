package com.notahmed.catsfinder.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record User (
        @Id
        long id,
        @NotBlank
        String username,
        @NotBlank
        String password,
        String phone,
        Gender gender,
        LocalDateTime birthDate,
        LocalDateTime detailsUpdated,

        // will point to table
        String userRoles
){}
