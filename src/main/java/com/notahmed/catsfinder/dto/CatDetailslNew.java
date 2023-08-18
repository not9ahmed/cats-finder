package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.Cat;
import com.notahmed.catsfinder.models.User;

public record CatDetailslNew(
        Cat cat,
        User user,
        Breed breed
){

}
