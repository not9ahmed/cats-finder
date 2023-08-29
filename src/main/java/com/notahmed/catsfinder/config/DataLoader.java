package com.notahmed.catsfinder.config;

import com.notahmed.catsfinder.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;

//@Controller
@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        // can save data here
        final UserRepository userRepository;

//        userRepository.saveAll()

        System.out.println("hello");

    }
}
