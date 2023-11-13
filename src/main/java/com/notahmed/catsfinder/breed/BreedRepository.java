package com.notahmed.catsfinder.breed;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends ListCrudRepository<Breed,Long> {


    List<Breed> findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase
            (@NotBlank String name, String description);

    List<Breed> findByName(@NotBlank String name);

    List<Breed> findByDescriptionContainingIgnoreCase(String description);

}
