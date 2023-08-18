package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.dto.CatDetails;
import com.notahmed.catsfinder.dto.CatDetailslNew;
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
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
@CrossOrigin(origins = "http://localhost:3000")
public class CatController {

    // Add Spring Data JDBC Repository which is CatRepository which is by default contains all the crud function
    private final CatRepository catRepository;

    // using the other repos
    private final UserRepository userRepository;
    private final BreedRepository breedRepository;


    // Dependency Injection of the repository here with constructor
    public CatController(CatRepository catRepository, UserRepository userRepository, BreedRepository breedRepository) {
        this.catRepository = catRepository;
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

        catRepository.findAll().stream().forEach(System.out::println);

        return catRepository.findAll();


//        return repository.findAll();
    }


    @GetMapping("/details")
    public List<CatDetails> findAllCatsWithDetails(){

        List<Cat> cats = catRepository.findAll();

        List<CatDetails> catsDetails = new ArrayList<>();


        // move it to mapper class
        for(Cat cat: cats){
//            Long breed_id = cat.breedId().getId();
//            Long owner_id = cat.ownerId().getId();
//
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



        return catsDetails;
    }


    // Get one cat
    @GetMapping("/{id}")
    //Add search query
    public Cat findById(@PathVariable Long id){


        return (Cat) catRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat Not Found"));


    }




    // Get user cats
    @GetMapping("/users/{id}")
    public List<Cat> findUserCats(@PathVariable Long id){


        return catRepository.findAllByOwnerId(id);

    }






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


//        AggregateReference<Breed, Long> breedID= AggregateReference.to(cat.breedId().getId());
//        AggregateReference<User, Long> userID= AggregateReference.to(cat.ownerId().getId());


//        System.out.println("breedID " + breedID);
//        System.out.println("userID " + userID);


//        catRepository.save(new Cat(
//                null,
//                cat.name(),
//                breedID,
//                userID,
//                cat.birth_date(),
//                cat.images(),
//                cat.toys()
//        ));

        catRepository.save(cat);

    }


    // Update Single cat
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Cat cat, @PathVariable Long id){

        //first check if the cat id exists or not
        if(!catRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat not found");
        }

        catRepository.save(cat);

    }



    // Delete Single Cat
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        //check if the id exists
        if(!catRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat not found");
        }

        catRepository.deleteById(id);

    }



    @GetMapping("/agg/all")
    public Iterable findAggAll(){
        return catRepository.findAll();
    }


    @GetMapping("/agg/{id}")
    public Cat findAggById(@PathVariable Long id){

        return catRepository.findById(id).orElse(null);
    }



    @GetMapping("/agg/{id}/details")
    public CatDetails findAggByIdDetails(@PathVariable Long id){

        Cat cat = catRepository.findById(id).orElse(null);

        CatDetails singleCatDetails = new CatDetails(
                cat.getId(),
                cat.getName(),
                breedRepository.findById(cat.getBreedId().getId()).get(),
                userRepository.findById(cat.getOwnerId().getId()).get(),
                cat.getBirth_date(),
                cat.getImages(),
                cat.getToys()
        );

        return singleCatDetails;

//        return new CatDetailslNew(
//                cat,
//                userRepository.findById(cat.getOwnerId().getId()).get(),
//                breedRepository.findById(cat.getBreedId().getId()).get()
//        );
    }
}



