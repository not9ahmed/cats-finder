package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.Cat;
import com.notahmed.catsfinder.models.User;

public record CatDetails (
        Cat cat,
        Breed breed,
        User user
){}
