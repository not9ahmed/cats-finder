package com.notahmed.catsfinder.cat;


import com.notahmed.catsfinder.breed.Breed;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

// will be the same class
@Table("Cat")
public record Cat (
//        @Id
//        Long id,
//
//        String name,
//        AggregateReference<Breed, Long> breedId,
//        AggregateReference<User, Long> ownerId,
//        Date birth_date,
//        ArrayList<String> images,
//        ArrayList<String> toys,
//
//        // nested collection very weak entity
//        // which means if the parent destroyed it will be deleted
//        // can be added to the cat
//        @MappedCollection(keyColumn = "id", idColumn = "cat")
//        Set<Comment> comments
){
    // adding the comment to the cat
//    public void addComment(Comment comment){
//
//        // adding comment to this class
//        comments.add(comment);
//
//        // adding reference from comment to this
//        comment.cat = this;
//    }
}