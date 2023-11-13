package com.notahmed.catsfinder.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* I can use my own
* This package will handle all the db calls and mapping
* */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // this is a must for authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //
//        User user = userRepository.findUserByUsername(username);

        // I can refactor my codes to use this class instead of repository
        // hard coded user
//        UserDetails userDetails = new User("notahmed",
//                "password",
//                new ArrayList<>()
//        );
//
//        return userDetails;

        // using my users
//        return new User();

        // using spring security
        // TODO: Choose which method to use
        /** dev notes
         * Models core user information retrieved by a UserDetailsService.
         * Developers may use this class directly, subclass it,
         * or write their own UserDetails implementation from scratch.
         */
        return new org.springframework.security.core.userdetails
                .User("notahmed","password", new ArrayList<>());
    }


    public ResponseEntity<List<com.notahmed.catsfinder.user.User>> findAll() {

        List<com.notahmed.catsfinder.user.User> usersLists = userRepository.findAll();



        return ResponseEntity.ok(null);
    }


    public ResponseEntity<com.notahmed.catsfinder.user.User> findById(Long id) {


        com.notahmed.catsfinder.user.User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));


        return ResponseEntity.ok(user);

    }



    // bad naming
    // TODO: change the user naming
    public ResponseEntity<com.notahmed.catsfinder.user.User> findByUsername(String username) {

        // choose the correct user class

        // return the correct status code

        com.notahmed.catsfinder.user.User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("not found"));

        return ResponseEntity.ok(user);

    }




}
