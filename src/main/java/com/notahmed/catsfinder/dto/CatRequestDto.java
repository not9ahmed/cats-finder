package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.ArrayList;
import java.util.Date;

/*
Class to represent the user request body
 */
public record CatRequestDto(
        Long id,
        String name,
        Long breed_id,
        Long owner_id,
        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys
) {}
