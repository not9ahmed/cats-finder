package com.notahmed.catsfinder.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        UserDetails userDetails = new User("notahmed",
                "password",
                new ArrayList<>()
        );

        return null;
    }
}
