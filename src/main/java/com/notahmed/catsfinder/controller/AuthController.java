package com.notahmed.catsfinder.controller;

import com.notahmed.catsfinder.services.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // create new instance of logger slf4j
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);


    // dependency injection
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }



    @PostMapping("/token")
    private String token(Authentication authentication) {

        LOG.debug("Token Request from user '{}'", authentication.getName());

        String token = tokenService.generateToken(authentication);

        LOG.debug("Token Granted {}", token);


        return token;
    }
}
