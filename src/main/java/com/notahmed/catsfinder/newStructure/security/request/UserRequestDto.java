package com.notahmed.catsfinder.newStructure.security.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

public record UserRequestDto(
        @NotBlank
        String username,
        @NotBlank
        String password,
        String first_name,
        String last_name,
        String mobile,
        Character gender,
        Date birth_date,
        LocalDateTime details_updated,
        String profile_image
) { }
