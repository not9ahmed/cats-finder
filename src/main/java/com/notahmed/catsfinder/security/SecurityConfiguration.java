package com.notahmed.catsfinder.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    // jwt service here
    // user details service here

    // steps
    // 1- add the @EnableWebSecurity
    // 2- create the DaoAuthenticationProvider which sets the user details service and password encoder
    // 3- create the securityFilterChain bean which disables the csrf and make requests stateless
    // 4- create the password encoder bean
    // 5- add the authenticationManager bean - VERY IMPORTANT





}
