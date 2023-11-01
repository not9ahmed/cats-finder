package com.notahmed.catsfinder.newStructure.post;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ListCrudRepository<Long, Post> {

    // db crud methods here

}
