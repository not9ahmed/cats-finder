package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.dto.CatDetails;
import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.Cat;
import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.BreedRepository;
import com.notahmed.catsfinder.repository.CatRepository;
import com.notahmed.catsfinder.repository.UserRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cats")
@CrossOrigin(origins = "http://localhost:3000")
public class CatController {

    // Add Spring Data JDBC Repository which is CatRepository which is by default contains all the crud function
    private final CatRepository repository;

    // using the other repos
    private final UserRepository userRepository;
    private final BreedRepository breedRepository;


    // Dependency Injection of the repository here with constructor
    public CatController(CatRepository repository, UserRepository userRepository, BreedRepository breedRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.breedRepository = breedRepository;
    }

    // Get all the cats
    @GetMapping("")
    //Add search query
    public List<Cat> getAllCats() {

        //checking the cat class


//        AggregateReference<Breed, Long> agg =  AggregateReference.to(1L);
//
//        Cat hazel = new Cat(
//                1L,
//                "Hazel",
//                1L,
//                3L,
//                new Date(),
//                new ArrayList<>(),
//                new ArrayList<>()
//        );
//
//
//        System.out.println(hazel.toString());

        repository.findAll().stream().forEach(System.out::println);

        return repository.findAll();


//        return repository.findAll();
    }


    @GetMapping("/details")
    public List<CatDetails> findAllCatsWithDetails(){

        List<Cat> cats = repository.findAll();

        List<CatDetails> catsDetails = new ArrayList<>();

        for(Cat cat: cats){
            Long breed_id = cat.breed_id().getId();
            Long owner_id = cat.owner_id().getId();

            Breed breed = breedRepository.findById(breed_id.longValue()).orElse(null);
            User user = userRepository.findById(owner_id.longValue()).orElse(null);


            CatDetails singleCatDetails = new CatDetails(cat, breed, user);


            catsDetails.add(singleCatDetails);


            System.out.println(singleCatDetails);
        }



        return catsDetails;
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

        System.out.println("----start of create----");

//        breedRepository.findById(cat.breed_id().getId());

        // add validation
//        AggregateReference<Cat, Long> breed_id = AggregateReference.to(cat.id());


//        System.out.println("Check " +cat

//        Person p1, p2 = // some initialization

        // p1.bestFriend = AggregateReference.to(p2.id);


//        Optional<Breed> breedReturned = breedRepository.findById(cat.breed_id().getId());


//        System.out.println(breedReturned);



//        AggregateReference breedRef = AggregateReference.to(cat.breed_id());

//        breedRepository.findById(cat.breed_id());






//        System.out.println(breedRepository.findById(cat.breed_id().getId()));

//        System.out.println(cat.toString());


//        // first get the breed from the requests
//        AggregateReference<Breed, Long> breedID = cat.breed_id();
//
//        System.out.println("Breed ID " + breedID);

//        boolean val = breedRepository.existsById(breedID.getId());



//        AggregateReference.to(cat);


        // if the user and breed does not exist
//        if (!userRepository.existsById(cat.owner_id()) && !breedRepository.existsById(cat.breed_id())) {
//            System.out.println("User and Breed do not exist");
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User and Breed do not exist");
//        }
//
//        // if the user does not exist
//        if(!userRepository.existsById(cat.owner_id())){
//            System.out.println("User does not exists");
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exists");
//        }
//
//        // if the breed does not exist
//        if(!breedRepository.existsById(cat.breed_id())){
//            System.out.println("Breed does not exists");
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Breed does not exists");
//        }



        repository.save(new Cat(
                null,
                cat.name(),
                cat.breed_id(),
                cat.owner_id(),
                cat.birth_date(),
                cat.images(),
                cat.toys()
        ));

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






}



