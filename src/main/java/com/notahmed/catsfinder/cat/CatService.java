package com.notahmed.catsfinder.cat;

import org.springframework.stereotype.Service;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }



}
