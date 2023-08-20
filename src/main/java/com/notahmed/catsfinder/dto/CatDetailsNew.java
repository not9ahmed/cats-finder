package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.Comment;
import com.notahmed.catsfinder.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Table("Cat")
public record CatDetailsNew(
        @Id
        Long id,

        String name,
        AggregateReference<Breed, Long> breedId,

//        @MappedCollection(keyColumn = "id", idColumn = "owner_id")
//        Set<User> ownerId,

//        @MappedCollection(keyColumn = "owner_id", idColumn = "id")
//        Set<User> owners,

        AggregateReference<User, Long> ownerId,




        Date birth_date,
        ArrayList<String> images,
        ArrayList<String> toys,

        @MappedCollection(keyColumn = "id", idColumn = "cat")
        Set<Comment> comments


){

}
