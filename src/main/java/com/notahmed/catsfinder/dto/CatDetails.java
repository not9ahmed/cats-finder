package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.model.Breed;
import com.notahmed.catsfinder.model.Comment;
import com.notahmed.catsfinder.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public record CatDetails (
        Long id,
        String name,
        Breed breed,
        User owner,
        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys,
        Set<Comment> comments
){


}
