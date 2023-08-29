package com.notahmed.catsfinder.controller;

import com.notahmed.catsfinder.dto.*;
import com.notahmed.catsfinder.mapper.UserMapper;
import com.notahmed.catsfinder.model.User;
import com.notahmed.catsfinder.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    // using java jdbc from the repository
    private final UserRepository userRepository;


    // injecting the custom mapper
    private final UserMapper userMapper;

    // add the constructor
    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // URL Paths Here and they will call some function in the repository
    // Data type returned will be based on the data return

    // user home controller where it will get all user
    @GetMapping("")
    public List<UserRequestDto> findAll(){

        List<User> usersList = userRepository.findAll();

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


        User userDb = userRepository.findById(id).orElseThrow(
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
        if (userRepository.existsByUsername(user.username())) {
            System.out.println("user already exists");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "user already exists");
        }


        System.out.println("User created");
        userRepository.save(user);

//        return new ResponseEntity<>(user, HttpStatus.OK);


    }


    // update existing user
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Long id){

        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        userRepository.save(user);


    }

    // delete user
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if (!userRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        userRepository.deleteById(id);
    }



    // sample collection
    @GetMapping("/{id}/cats")
    public UserJoinedDto findAllUserCats(@PathVariable Long id){

        List <UserCatsJoinedDto> userCats = userRepository.findUserCats(id);

        System.out.println("usercats list");
        userCats.forEach(System.out::println);


        UserJoinedDto user = userMapper.mapToUserJoinedDto(userCats);


        return user;
    }


    @GetMapping("/{id}/cats/comments")
    public UserJoinedDto findUserCatsAndComments(@PathVariable Long id){




        // check  check if it is empty
        List <UserCatsCommentsJoinedDto> userCats = userRepository.findUserCatsAndComments(id);


        if (userCats.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        System.out.println(userCats);


        // mapper
        UserJoinedDto user = userMapper.mapUserCat(userCats);

        System.out.println(user);


        return user;
    }


    @GetMapping("/cats/comments")
    public List<UserJoinedDto> findAllUsersCatsAndComments(){


        // check  check if it is empty
        List <UserCatsCommentsJoinedDto> userCats = userRepository.findAllUsersCatsAndComments();


        System.out.println(userCats);


        // mapper
        List<UserJoinedDto> users = userMapper.mapUsersCatList(userCats);

        System.out.println(users);


        return users;
    }



    @GetMapping("/search")
    public User searchForUser(@RequestParam(required = false) String q){

        User user = userRepository.findUserByUsername(q);


        return user;

    }

}
