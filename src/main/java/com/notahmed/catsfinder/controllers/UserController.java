package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.dto.CatDetailsNew;
import com.notahmed.catsfinder.dto.UserRequestDto;
import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserRequestDto> findAll(){

        List<User> usersList = repository.findAll();

        List<UserRequestDto> usersListFiltered  = usersList.stream().map(user -> new UserRequestDto(
                user.id(),
                user.username(),
                user.first_name(),
                user.last_name(),
                user.gender(),
                user.birth_date(),
                user.profile_image()
        )).collect(Collectors.toList());

        return usersListFiltered;
    }

    @GetMapping("/{id}")
    public UserRequestDto findById(@PathVariable Long id){

        System.out.println("find by id");
//        return (User) repository.findById(id).orElse();


        User userDb = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );

        UserRequestDto user = new UserRequestDto(
                userDb.id(),
                userDb.username(),
                userDb.first_name(),
                userDb.last_name(),
                userDb.gender(),
                userDb.birth_date(),
                userDb.profile_image()
        );

        return user;
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



    // sample collection
    @GetMapping("/{id}/cats")
    public User findAllUseCats(@PathVariable Long id){

        User userCatsAndComments = repository.findUserCatsAndComments(id);




        return userCatsAndComments;
    }

}
