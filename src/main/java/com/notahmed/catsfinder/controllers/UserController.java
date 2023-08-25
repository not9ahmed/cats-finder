package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.dto.*;
import com.notahmed.catsfinder.mapper.UserDTOMapper;
import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    // using java jdbc from the repository
    private final UserRepository repository;


    // injecting the custom mapper
    private final UserDTOMapper userDTOMapper;

    // add the constructor
    public UserController(UserRepository repository, UserDTOMapper userDTOMapper) {
        this.repository = repository;
        this.userDTOMapper = userDTOMapper;
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
    public UserJoinedDto findAllUserCats(@PathVariable Long id){

        List <UserCatsJoinedDto> userCats = repository.findUserCats(id);

        System.out.println("usercats list");
        userCats.forEach(System.out::println);





        // in stream
//        Set<CatJoinedDto> cats = userCats.stream().map(cat -> new CatJoinedDto(
//                cat.catId(),
//                cat.catName(),
//                cat.catBirthDate(),
//                null
//        )).collect(Collectors.toSet());


//        UserJoinedDto user = new UserJoinedDto(
//                userCats.get(0).userId(),
//                userCats.get(0).username(),
//                userCats.get(0).firstName(),
//
//                userCats.get(0).lastName(),
//                userCats.get(0).mobile(),
//                userCats.get(0).gender(),
//                userCats.get(0).userBirthDate(),
//                cats
//
//        );


        UserJoinedDto user = mapToUserJoinedDto(userCats);




        return user;
    }


    @GetMapping("/{id}/cats/comments")
    public UserJoinedDto findAllUserCatsAndComments(@PathVariable Long id){

        List <UserCatsCommentsJoinedDto> userCats = repository.findUserCatsAndComments(id);


        System.out.println(userCats);


        // 1- map rows to commments
        // map comments to the cats
        // 2 map cat to user



//        yourTypes.stream()
//                .collect(Collectors.groupingBy(
//                        ObjectA::getType,
//                        Collectors.mapping(
//                                ObjectA::getId, Collectors.toList()
//                        )))




        // works !!
        Map<Long, Set<CommentJoinedDto>> commentsMap =
                userCats.stream().map(row -> new CommentJoinedDto(
                                        row.commentId(),
                                        row.catId(),
                                        row.commentName(),
                                        row.commentContent(),
                                        row.commentPublishedOn(),
                                        row.commentUpdatedOn()))
                        .collect(Collectors.groupingBy(CommentJoinedDto::cat,Collectors.toSet()));

        System.out.println(commentsMap);


        // mapping the cats to owner
        Map<Long, Set<CatJoinedDto>> catsMap = userCats.stream().map(row -> new CatJoinedDto(
                row.catId(),
                row.catName(),
                row.catBirthDate(),
                row.userId(),
                commentsMap.get(row.catId())
        )).collect(Collectors.groupingBy(CatJoinedDto::ownerId, Collectors.toSet()));


        System.out.println(catsMap);


        // map catMap to owner

        UserJoinedDto user = userCats.stream().findAny().map(row -> new UserJoinedDto(
                row.userId(),
                row.username(),
                row.firstName(),
                row.lastName(),
                row.mobile(),
                row.gender(),
                row.userBirthDate(),
                catsMap.get(row.userId())
        )).orElse(null);


//        Map<Long, CommentJoinedDto> collect = userCats.stream()
//                .collect(Collectors.toMap(UserCatsCommentsJoinedDto::catId, row ->
//                        new CommentJoinedDto(
//                                row.commentId(),
//                                row.catId(),
//                                row.commentName(),
//                                row.commentContent(),
//                                row.commentPublishedOn(),
//                                row.commentUpdatedOn()
//                        )));






        return user;
    }




    public static UserJoinedDto mapToUserJoinedDto(List <UserCatsJoinedDto> userCats){


//        Set<CatJoinedDto> cats = userCats.stream().map(cat -> new CatJoinedDto(
//                cat.catId(),
//                cat.catName(),
//                cat.catBirthDate(),
//                null
//        )).collect(Collectors.toSet());


        UserJoinedDto user = new UserJoinedDto(
                userCats.get(0).userId(),
                userCats.get(0).username(),
                userCats.get(0).firstName(),

                userCats.get(0).lastName(),
                userCats.get(0).mobile(),
                userCats.get(0).gender(),
                userCats.get(0).userBirthDate(),
                userCats.stream().map(cat -> new CatJoinedDto(
                        cat.catId(),
                        cat.catName(),
                        cat.catBirthDate(),
                        null,
                        null
                )).collect(Collectors.toSet())

        );

        return user;


    }
}
