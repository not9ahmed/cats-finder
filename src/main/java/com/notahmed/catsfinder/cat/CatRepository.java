package com.notahmed.catsfinder.cat;

import com.notahmed.catsfinder.breed.Breed;
import com.notahmed.catsfinder.user.User;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CatRepository extends ListCrudRepository<Cat, Long > {

    // db crud methods here
    List<Cat> findAllByBreedId(AggregateReference<Breed, Long> breedId);

    List<Cat> findAllByOwnerId(AggregateReference<User, Long> ownerId);


    List<Cat> findAllByBirth_dateBetween(Date dateStart, Date dateEnd);

}
