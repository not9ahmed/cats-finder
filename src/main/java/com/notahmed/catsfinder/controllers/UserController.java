package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
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


    //Create a new user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody User user){

        repository.save(user);
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

    // delete use
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        repository.deleteById(id);
    }

}
