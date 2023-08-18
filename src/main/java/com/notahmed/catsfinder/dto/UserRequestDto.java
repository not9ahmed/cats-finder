package com.notahmed.catsfinder.dto;

import org.springframework.data.annotation.Id;
import java.util.Date;

/*
* Create request Dto to hide fields
* */
public record UserRequestDto(
        @Id
        Long id,
        String username,
        String first_name,
        String last_name,
        Character gender,
        Date birth_date,
        String profile_image
) {}
