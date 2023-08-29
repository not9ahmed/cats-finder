package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.model.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

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
        ArrayList<String> toys,
        Set<Comment> comments
) {}
