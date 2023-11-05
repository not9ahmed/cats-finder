package com.notahmed.catsfinder.cat;

import com.notahmed.catsfinder.cat.request.CatRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

}
