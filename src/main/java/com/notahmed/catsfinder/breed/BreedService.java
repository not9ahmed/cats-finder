package com.notahmed.catsfinder.breed;

import com.notahmed.catsfinder.breed.request.BreedRequest;
import com.notahmed.catsfinder.breed.response.BreedResponse;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedService {

    private final BreedRepository breedRepository;

    // service will take breed in the shape of request dto
//    then it will maps it be used in the repository class

    public BreedService(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }


    public ResponseEntity<?> findAll() {

        // verify the request


        List<Breed> breeds = breedRepository.findAll();

        return ResponseEntity.ok(breeds);

    }


    /**
     * service to create a new breed
     * @param breedRequest
     * @return
     */
    public ResponseEntity<BreedResponse> create(BreedRequest breedRequest) {

        // do validation
        // then the mapping here
        // then save in db

//        new Breed();

        Breed breedSaved = breedRepository.save(null);

        ResponseEntity.ok(breedSaved);

        // map again to breed response type

        return null;
    }


    public ResponseEntity<BreedResponse> findById(Long id) {

        // user better exceptions here such as 404
        Breed breed = breedRepository.findById(id).orElse(null);

        // map the resource to response dto

        // based on exception return the ok or not

        return ResponseEntity.ok(null);
    }


    private ResponseEntity<BreedResponse> update(BreedRequest breedRequest) {

        // check if the breed request is valid

        // update in the db


//        breedRepository.save(null);

        return ResponseEntity.ok(null);
    }


}
