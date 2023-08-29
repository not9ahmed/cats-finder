package com.notahmed.catsfinder.repository;

import com.notahmed.catsfinder.model.Breed;
import org.springframework.data.repository.ListCrudRepository;

public interface BreedRepository extends ListCrudRepository<Breed, Long> {
}
