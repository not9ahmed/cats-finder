package com.notahmed.catsfinder.mapper;

import com.notahmed.catsfinder.dto.CatDetails;
import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.Cat;
import com.notahmed.catsfinder.models.User;

import java.util.ArrayList;
import java.util.List;


public class CatDTOMapper {
//    private final List<CatDetails>;

    public List <CatDetails> CatDTOMapper(){

        List<Cat> cats = new ArrayList<>();

        // move it to mapper class
        for(Cat cat: cats){
//            Long breed_id = cat.breedId().getId();
//            Long owner_id = cat.ownerId().getId();

//            Breed breed = breedRepository.findById(breed_id.longValue()).orElse(null);
//            User user = userRepository.findById(owner_id.longValue()).orElse(null);


//            CatDetails singleCatDetails = new CatDetails(
//                    cat.id(),
//                    cat.name(),
//                    breed,
//                    user,
//                    cat.birth_date(),
//                    cat.images(),
//                    cat.toys()
//            );


//            catsDetails.add(singleCatDetails);
//
//
//            System.out.println(singleCatDetails);
        }

        return new ArrayList <CatDetails>();
    }
}
