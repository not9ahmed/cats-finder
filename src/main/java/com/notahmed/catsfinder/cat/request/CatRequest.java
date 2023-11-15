package com.notahmed.catsfinder.cat.request;

import com.notahmed.catsfinder.breed.Breed;
import com.notahmed.catsfinder.cat.Comment;
import com.notahmed.catsfinder.user.User;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record CatRequest (
//        Long id,

        String name,
        AggregateReference<Breed, Long> breedId,
        AggregateReference<User, Long> ownerId,
        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys,
        List<Comment> comments

        // nested collection very weak entity
        // which means if the parent destroyed it will be deleted
        // can be added to the cat
//        @MappedCollection(keyColumn = "id", idColumn
){ }
