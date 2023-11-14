package com.notahmed.catsfinder.cat;

import com.notahmed.catsfinder.breed.Breed;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends ListCrudRepository<Cat, Long > {

    // db crud methods here
    List<Cat>findAllByBreedId(AggregateReference<Breed, Long> breedId);
}
