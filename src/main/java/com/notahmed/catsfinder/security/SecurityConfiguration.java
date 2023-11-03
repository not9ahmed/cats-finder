package com.notahmed.catsfinder.security;

import com.notahmed.catsfinder.user.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    // jwt service here
    private final JwtService jwtService;

    // user details service here
    // always add the service in the MyUserDetailsService so that spring security find its
    private final MyUserDetailsService myuserDetailsService;

    public SecurityConfiguration(JwtService jwtService, MyUserDetailsService myuserDetailsService) {
        this.jwtService = jwtService;
        this.myuserDetailsService = myuserDetailsService;
    }

    // steps
    // 1- add the @EnableWebSecurity
    // 2- create the DaoAuthenticationProvider which sets the user details service and password encoder
    // 3- create the securityFilterChain bean which disables the csrf and make requests stateless
    // 4- create the password encoder bean
    // 5- add the authenticationManager bean - VERY IMPORTANT



    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(myuserDetailsService);

        // gets from the bean below
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());


        return daoAuthenticationProvider;
    }



    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }


    // this used to register the authentication manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }






    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // add filter

        http
                .csrf(csrfConfigurer ->csrfConfigurer.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/users/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/api/v1/").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).formLogin(Customizer.withDefaults());


        return http.build();
    }
}
