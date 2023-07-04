package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    // using java jdbc from the repository
    private final UserRepository repository;


    // add the constructor
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // URL Paths Here and they will call some function in the repository
    // Data type returned will be based on the data return

    // user home controller where it will get all user
    @GetMapping("")
    public List<User> findAll(){

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){

//        return (User) repository.findById(id).orElse();

        return (User) repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }


    //Create a new user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody User user){


        //check if the user exists first
        if (repository.existsByUsername(user.username())) {
            System.out.println("user already exists");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "user already exists");
        }


        System.out.println("User created");
        repository.save(user);

//        return new ResponseEntity<>(user, HttpStatus.OK);


    }


    // update existing user
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Long id){

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        repository.save(user);


    }

    // delete user
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        repository.deleteById(id);
    }

}
