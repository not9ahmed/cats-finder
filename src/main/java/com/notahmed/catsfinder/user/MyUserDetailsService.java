package com.notahmed.catsfinder.user;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// I already have it inside the security but here it's more logical
@Service
public class MyUserDetailsService implements UserDetailsService {

    // fetches data from DB
    // or from the repository
    // it is also safer this way
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        // I can refactor my codes to use this class instead of repository


        UserDetails userDetails = new User("notahmed",
                "password",
                new ArrayList<>()
        );



        return userDetails;
    }
}
