package com.notahmed.catsfinder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/api/auth")
public class AuthHomeController {




    @GetMapping("/")
    public String authHome(Principal principal){
        return "Hello, " + principal.getName();
    }
}
