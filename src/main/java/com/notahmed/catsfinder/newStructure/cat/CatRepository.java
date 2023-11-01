package com.notahmed.catsfinder.newStructure.cat;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends ListCrudRepository<Long, Cat> {

    // db crud methods here
}