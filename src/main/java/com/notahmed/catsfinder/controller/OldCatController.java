package com.notahmed.catsfinder.controller;

import com.notahmed.catsfinder.dto.CatDetails;
import com.notahmed.catsfinder.dto.CatRequestDto;
import com.notahmed.catsfinder.model.Cat;
import com.notahmed.catsfinder.model.Comment;
import com.notahmed.catsfinder.repository.BreedRepository;
import com.notahmed.catsfinder.repository.CatRepository;
import com.notahmed.catsfinder.repository.UserRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
@CrossOrigin(origins = "http://localhost:3000")
public class OldCatController {

    // Add Spring Data JDBC Repository which is CatRepository which is by default contains all the crud function
    private final CatRepository catRepository;

    // using the other repos
    private final UserRepository userRepository;
    private final BreedRepository breedRepository;


    // Dependency Injection of the repository here with constructor
    public OldCatController(CatRepository catRepository, UserRepository userRepository, BreedRepository breedRepository) {
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
    public void create(@RequestBody CatRequestDto cat){

        System.out.println("----start of create----");

        System.out.println(cat);

//        breedRepository.findById(cat.breed_id().getId());


        //check ig the breed id and owner exists first

        boolean ownerExists = userRepository.existsById(cat.owner_id());

        boolean breedExists = breedRepository.existsById(cat.breed_id());

        if (!ownerExists || !breedExists ) {

            System.out.println("Invalid parameter");

            return;
        }

        catRepository.save(
                new Cat(
                        null,

                        cat.name(),
                        AggregateReference.to(cat.breed_id()),
                        AggregateReference.to(cat.owner_id()),
                        cat.birth_date(),
                        cat.images(),
                        cat.toys(),
                null
                        )

        );







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


    @GetMapping("/agg/all/details")
    public Iterable findAggAllWithDetails(){

        List<Cat> cats = catRepository.findAll();


        List<CatDetails> catsDetails = new ArrayList<>();


        cats.forEach(cat -> {
            catsDetails.add(new CatDetails(
                    cat.id(),
                    cat.name(),
                    breedRepository.findById(cat.breedId().getId()).get(),
                    userRepository.findById(cat.ownerId().getId()).get(),
                    cat.birth_date(),
                    cat.images(),
                    cat.toys(),
                    cat.comments()
            ));
        });




        return catsDetails;
    }


    @GetMapping("/agg/{id}")
    public Cat findAggById(@PathVariable Long id){

        return catRepository.findById(id).orElse(null);
    }



    @GetMapping("/agg/{id}/details")
    public CatDetails findAggByIdDetails(@PathVariable Long id){

        Cat cat = catRepository.findById(id).orElse(null);

//        CatDetails singleCatDetails = new CatDetails(
//                cat.getId(),
//                cat.getName(),
//                breedRepository.findById(cat.getBreedId().getId()).get(),
//                userRepository.findById(cat.getOwnerId().getId()).get(),
//                cat.getBirth_date(),
//                cat.getImages(),
//                cat.getToys(),
//                cat.getComments()
//        );

        CatDetails singleCatDetails = new CatDetails(
                cat.id(),
                cat.name(),
                breedRepository.findById(cat.breedId().getId()).get(),
                userRepository.findById(cat.ownerId().getId()).get(),
                cat.birth_date(),
                cat.images(),
                cat.toys(),
                cat.comments()
        );

        return singleCatDetails;

    }


    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CatDetails createCatComment(@PathVariable Long id, @RequestBody Comment comment){


        // adding comment first way
        Cat cat = catRepository.findById(id).get();
        cat.addComment(comment);



        catRepository.save(cat);


        // map the cat to dto
        CatDetails catDetails = new CatDetails(
                cat.id(),
                cat.name(),
                breedRepository.findById(cat.breedId().getId()).get(),
                userRepository.findById(cat.ownerId().getId()).get(),
                cat.birth_date(),
                cat.images(),
                cat.toys(),
                cat.comments()
        );



        return catDetails;
    }


    @DeleteMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteCatComment(@PathVariable Long id, @RequestBody Comment comment) {


        // adding comment first way
//        Cat cat = catRepository.findById(id).get();
//        cat.removeComment(comment);
//        catRepository.save(cat);




        // using custom query works
        catRepository.deleteCommentById(id);

        System.out.println("Delete success");


//        Cat cat = catRepository.findById(id).get();
//
//        System.out.println("cat returned "+ cat);
//
//        // map the cat to dto
//        CatDetails catDetails = new CatDetails(
//                cat.id(),
//                cat.name(),
//                breedRepository.findById(cat.breedId().getId()).get(),
//                userRepository.findById(cat.ownerId().getId()).get(),
//                cat.birth_date(),
//                cat.images(),
//                cat.toys(),
//                cat.comments()
//        );


        return "success";
    }



}



