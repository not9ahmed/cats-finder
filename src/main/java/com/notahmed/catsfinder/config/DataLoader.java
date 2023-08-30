package com.notahmed.catsfinder.config;

import com.notahmed.catsfinder.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;


// This Command Line class will run only with the dev profile
@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        // can save data here
        final UserRepository userRepository;

//        userRepository.saveAll()

        System.out.println("hello from data loader");

    }
}
