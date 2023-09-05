package com.notahmed.catsfinder.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notahmed.catsfinder.model.User;
import com.notahmed.catsfinder.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
//import org.springframework.stereotype.Controller;


// This Command Line class will run only with the dev profile
//@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    // comes from jackson
    // way to create objects out of json and deserialize to json
    private final ObjectMapper objectMapper;

    public DataLoader(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {


        System.out.println("hello from data loader");

        if (userRepository.count() == 0) {

            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {

                userRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<User>>() {
                }));


            }

        }
    }
}