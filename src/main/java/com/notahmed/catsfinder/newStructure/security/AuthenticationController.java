package com.notahmed.catsfinder.newStructure.security;

import com.notahmed.catsfinder.newStructure.security.request.UserRequestDto;
import com.notahmed.catsfinder.newStructure.security.response.UserResponseDto;
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
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserRequestDto user) {

        // validation should be done an mapper
        UserResponseDto msg = new UserResponseDto(
                "user created"
        );

        return ResponseEntity.ok(msg);
    }




}
