package com.notahmed.catsfinder.breed;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends ListCrudRepository<Breed,Long> {
}
