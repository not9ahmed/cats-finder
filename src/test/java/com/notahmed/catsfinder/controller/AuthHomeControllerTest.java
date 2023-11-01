package com.notahmed.catsfinder.controller;

import com.notahmed.catsfinder.config.SecurityConfig;
import com.notahmed.catsfinder.services.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest({AuthHomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class AuthHomeControllerTest {



    @Autowired
    MockMvc mvc;


    @Test
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mvc.perform(get("/api/auth"))
                .andExpect(status().isUnauthorized());
    }


    @Test
    void rootWhenAuthenticatedThenSaysHelloToUser () throws Exception {
        MvcResult result = this.mvc.perform(post("/api/auth/token")
                        .with(httpBasic("notahmed", "password")))
                .andExpect(status().isOk())
                .andReturn();

        String token = result.getResponse().getContentAsString();

        this.mvc.perform(get("/api/auth/").
                        header("Authorization", "Bearer " + token))
                .andExpect(content().string("Hello, notahmed"));

    }




    @Test
    @WithMockUser
    public void rootWithMockStatusIsOK() throws Exception {

        this.mvc.perform(get("/api/auth/")).andExpect(status().isOk());

    }
}