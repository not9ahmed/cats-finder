package com.notahmed.catsfinder.cat.request;

import java.util.ArrayList;
import java.util.Date;

public record CatRequest (
        Long id,

        String name,
//        AggregateReference<Breed, Long> breedId,
//        AggregateReference<User, Long> ownerId,
        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys
//        ,

        // nested collection very weak entity
        // which means if the parent destroyed it will be deleted
        // can be added to the cat
//        @MappedCollection(keyColumn = "id", idColumn
){ }
