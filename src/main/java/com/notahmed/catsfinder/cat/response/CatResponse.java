package com.notahmed.catsfinder.cat.response;

import com.notahmed.catsfinder.breed.Breed;
import com.notahmed.catsfinder.user.User;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.ArrayList;
import java.util.Date;

public record CatResponse(

        String name,
        AggregateReference<Breed, Long>breedId,
        AggregateReference<User, Long> ownerId,
        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys
) {
}
