package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.models.Cat;
import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.CatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
@CrossOrigin(origins = "http://localhost:3000")
public class CatController {

    // Add Spring Data JDBC Repository which is CatRepository which is by default contains all the crud function
    private final CatRepository repository;

    // Dependency Injection of the repository here with constructor
    public CatController(CatRepository repository){
        this.repository = repository;
    }

    // Get all the cats
    @GetMapping("")
    //Add search query
    public List<Cat> getAllCats(){

        return repository.findAll();
    }


    // Get one cat
    @GetMapping("/{id}")
    //Add search query
    public Cat findById(@PathVariable Long id){


        return (Cat) repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat Not Found"));


    }




    // Get many cats of type




    // add new cat
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Cat cat){

        // add validation


        repository.save(cat);
    }


    // Update Single cat
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Cat cat, @PathVariable Long id){

        //first check if the cat id exists or not
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat not found");
        }

        repository.save(cat);

    }



    // Delete Single Cat
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        //check if the id exists
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat not found");
        }

        repository.deleteById(id);

    }





    // Get all my cats
    //  /api/user/{ahmed}/cats
    //    /users // list all users
    //   /users/123 // specific user
    //     /users/123/orders //list of orders that belong to a specific user
    //   /users/123/orders/0001 // specific orders of a specific users order list


}



