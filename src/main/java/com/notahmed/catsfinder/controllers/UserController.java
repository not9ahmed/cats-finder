package com.notahmed.catsfinder.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notahmed.catsfinder.dto.*;
import com.notahmed.catsfinder.mapper.UserDTOMapper;
import com.notahmed.catsfinder.mapper.UserJoinedDtoMapper;
import com.notahmed.catsfinder.models.Comment;
import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<UserJoinedDto> findAllUserCatsAndComments(@PathVariable Long id){

        List <UserCatsCommentsJoinedDto> userCats = repository.findUserCatsAndComments(id);

        HashMap<Long, CommentJoinedDto> catComments = new HashMap<Long, CommentJoinedDto>();




        for (UserCatsCommentsJoinedDto c: userCats) {
            catComments.put(c.commentId(), new CommentJoinedDto(
                    c.commentId(),
                    c.commentName(),
                    c.commentContent(),
                    c.commentPublishedOn(),
                    c.commentUpdatedOn())
            );

        }


        System.out.println("catComments");

        System.out.println(catComments.toString());


        HashMap<Long, CatJoinedDto> cats = new HashMap<Long, CatJoinedDto>();

        for (UserCatsCommentsJoinedDto c: userCats) {



            cats.put(c.commentId(), new CatJoinedDto(
                    c.catId(),
                    c.catName(),
                    c.catBirthDate(),
                    null
            ));

        }


        System.out.println("catsWithComments");

        System.out.println(cats.toString());

//
//        for(CommentJoinedDto comment : catComments.values()){
//
//            for (CatJoinedDto cat : cats.values()) {
//
//                if (comment.cat() == cat.) {
//
//                }
//            }
//        }




//        for (UserCatsCommentsJoinedDto c: userCats) {
//            catComments.put(c.commentId(), new CommentJoinedDto(
//                    c.commentId(),
//                    c.commentName(),
//                    c.commentContent(),
//                    c.commentPublishedOn(),
//                    c.commentUpdatedOn())
//            );
//
//        }


//        // printing joined table
//        System.out.println("priniting joined cats");
//        userCats.forEach(System.out::println);
//
//        // map the comments then cats, then user
//        Set<CommentJoinedDto> comments = userCats.stream().map(comment -> new CommentJoinedDto(
//                comment.commentId(),
//                comment.commentName(),
//                comment.commentContent(),
//                comment.commentPublishedOn(),
//                comment.commentUpdatedOn()
//        )).collect(Collectors.toSet());
//
//
//        System.out.println("comments");
//        comments.forEach(System.out::println);
//
//
//        Set<CatJoinedDto> catsWithComments = userCats.stream().map(cat -> new CatJoinedDto(
//                cat.catId(),
//                cat.catName(),
//                cat.catBirthDate(),
//                comments
//        )).collect(Collectors.toSet());
//
//
//        catsWithComments.forEach(System.out::println);
//
//
//        System.out.println("only the first");
//        CatJoinedDto catJoinedDto = catsWithComments;

//        System.out.println(catJoinedDto);


//        new UserJoinedDto(
//
//                catsWithComments.stream().findFirst().map(
//
//                userCats.get(0).username(),
//                userCats.get(0).firstName(),
//
//                userCats.get(0).lastName(),
//                userCats.get(0).mobile(),
//                userCats.get(0).gender(),
//                userCats.get(0).userBirthDate(),
//                cats
//                )
//        ));


        // mapping cats to user
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

//        System.out.println("usercats and comments list");
//        userCats.forEach(System.out::println);


//        UserJoinedDto user = mapToUserJoinedDto(userCats);


        // in stream
//        Set<CatJoinedDto> cats = userCats.stream().map(cat -> new CatJoinedDto(
//                cat.catId(),
//                cat.catName(),
//                cat.catBirthDate(),
//                null
//        )).collect(Collectors.toSet());
//
//
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

//        Stream<UserJoinedDto> user = userCats.stream().map(userDTOMapper);





        return null;
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
                        null
                )).collect(Collectors.toSet())

        );

        return user;


    }
}
