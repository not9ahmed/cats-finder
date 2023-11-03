package com.notahmed.catsfinder.examples;

import com.notahmed.catsfinder.config.CatFinderProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// example of properties injection
@RestController
public class HomeController {



    // here we are injecting certain properties
//    private final CatFinderProperties properties;

//    public HomeController(CatFinderProperties properties) {
//        this.properties = properties;
//    }

//    @GetMapping("/")
//    public Map<String,String> home(){
//        return Map.of("welcomeMessage", welcomeMessage, "about", about);
//    }

//    @GetMapping("/")
//    public CatFinderProperties home(){
//
//        return properties;
//    }
}
