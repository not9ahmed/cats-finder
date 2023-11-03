package com.notahmed.catsfinder.security;

import com.notahmed.catsfinder.user.MyUserDetailsService;
import com.notahmed.catsfinder.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    // jwt service here
    private final JwtService jwtService;

    // user details service here
    // always add the service in the MyUserDetailsService so that spring security find its
    private final UserService userService;

    public SecurityConfiguration(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    // steps
    // 1- add the @EnableWebSecurity
    // 2- create the DaoAuthenticationProvider which sets the user details service and password encoder
    // 3- create the securityFilterChain bean which disables the csrf and make requests stateless
    // 4- create the password encoder bean
    // 5- add the authenticationManager bean - VERY IMPORTANT



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // add filter

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v0/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/api/v0/users/**").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers("/**").permitAll()
                                .anyRequest().permitAll()
//                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(daoAuthenticationProvider())
                .formLogin(Customizer.withDefaults());


        return http.build();
    }




    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userService);
        // gets from the bean below
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }



    @Bean
    public PasswordEncoder passwordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }


    // this used to register the authentication manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }







}
