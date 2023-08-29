package com.notahmed.catsfinder.controller;

import com.notahmed.catsfinder.model.Breed;
import com.notahmed.catsfinder.repository.BreedRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/breeds")
@CrossOrigin(origins = "http://localhost:3000")
public class BreedController {

    // Add the breedrepository
    private final BreedRepository repository;


    // add the constructor with dependency injection
    public BreedController(BreedRepository repository){
        this.repository = repository;
    }


    // Get all breed
    @GetMapping("")
    public List<Breed> findAll(){
        return repository.findAll();
    }


    // Get one breed by id
    @GetMapping("/{id}")
    public Breed findById(@PathVariable Long id){

        // check if this breed exists or not
        return (Breed) repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Breed not found"));

    }

    // create new breed
    @PostMapping("")
    public void create(@RequestBody Breed breed){

        //Add validation

        repository.save(breed);
    }


    // update breed
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Breed breed, @PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Breed not found");
        }


        repository.save(breed);
    }


    // Delete breed
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Breed not found");
        }

        repository.deleteById(id);
    }
}
