package com.notahmed.catsfinder.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    // authenticate create token
    @PostMapping("/login")
    public ResponseEntity<?> authenticate() {

        return null;

    }

    @PostMapping("/signup")
    /**
     *
     */
    public ResponseEntity<?> signup(@RequestBody UserRequest) {

        return null;
    }




}
