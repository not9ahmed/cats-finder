package com.notahmed.catsfinder.controllers;

import com.notahmed.catsfinder.models.Cat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    // Add Spring Data JDBC Repository which is CatRepository which is by default contains all the crud function


    // Dependency Injection of the repository here with constructor


    // Get all the cats
    @GetMapping("")
    //Add search query
    public List<Cat> getAllCats(){

        return new ArrayList<Cat>();
    }


    // Get many cats of type



    // Get single cat
    @GetMapping("/{id}")
    public Cat getOneCat(@PathVariable Long id){
        return new Cat(
                id,
                "Hazel",
                3,
                LocalDateTime.now()
        );
    }


    // Update Single cat


    // Delete Single Cat





    // Get all my cats
    //  /api/user/{ahmed}/cats
    //    /users // list all users
    //   /users/123 // specific user
    //     /users/123/orders //list of orders that belong to a specific user
    //   /users/123/orders/0001 // specific orders of a specific users order list


}



