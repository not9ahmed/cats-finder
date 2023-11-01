package com.notahmed.catsfinder.newStructure.user;

import com.notahmed.catsfinder.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
* This package will handle all the db calls and mapping
* */
@Service
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //
        User user = userRepository.findUserByUsername(username);

        return null;
    }
}
