package com.notahmed.catsfinder.cat;

import com.notahmed.catsfinder.breed.Breed;
import com.notahmed.catsfinder.cat.request.CatRequest;
import com.notahmed.catsfinder.cat.response.CatResponse;
import com.notahmed.catsfinder.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    public Cat save(CatRequest catRequest){


        Cat cat = catRepository.save(null);
        return cat;
    }


    public String update(Long catId, CatRequest catRequest) {

        Optional<Cat> catIdDb = catRepository.findById(catId);

        if(!catIdDb.isPresent()){
            return "not found";
        }

        catRepository.save(null);

        return "updated";

    }



    public String delete(Long catId) {
        catRepository.deleteById(catId);

        return "deleted";
    }


    public List<Cat> search(String q) {

        // custom sql
        catRepository.save(null);

        return new ArrayList<>();

    }

    public ResponseEntity<CatResponse> findById(Long id) {

        // check from db if the cat exists
        Cat cat = catRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such cat"));

        // map the cat to response entity with the correct status code

        ResponseEntity<Cat> catRes = ResponseEntity.ok(cat);

        // return the correct response data type
        return null;
    }


    public ResponseEntity<List<CatResponse>> findCatsByBreedId(Long breedId) {


        AggregateReference<Breed, Long> breedAggRefId = AggregateReference.to(breedId);


        List<Cat> cats = catRepository.findAllByBreedId(breedAggRefId);


        ResponseEntity.ok(null);

        return null;
    }


    public ResponseEntity<List<CatResponse>> findCatsByOwnerID(Long ownerId) {

        AggregateReference<User, Long> ownerAggRefId = AggregateReference.to(ownerId);


        List<Cat> cats = catRepository.findAllByOwnerId(ownerAggRefId);

        // do the mapping


        ResponseEntity.ok(null);

        return null;
    }



    public ResponseEntity<List<CatResponse>> findCatsByBirthDate(Date dateStart, Date dateEnd) {

        List<Cat> cats = catRepository.findAllByBirth_dateBetween(dateStart, dateEnd);


        ResponseEntity.ok(null);


        return null;
    }

}
