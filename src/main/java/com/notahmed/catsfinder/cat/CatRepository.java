package com.notahmed.catsfinder.cat;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends ListCrudRepository<Cat, Long > {

    // db crud methods here
}