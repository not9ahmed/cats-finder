package com.notahmed.catsfinder.controller;

import com.notahmed.catsfinder.config.CatFinderProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    private final CatFinderProperties properties;

    public HomeController(CatFinderProperties properties) {
        this.properties = properties;
    }

//    @GetMapping("/")
//    public Map<String,String> home(){
//        return Map.of("welcomeMessage", welcomeMessage, "about", about);
//    }

    @GetMapping("/")
    public CatFinderProperties home(){

        return properties;
    }
}
