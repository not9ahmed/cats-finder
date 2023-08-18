package com.notahmed.catsfinder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@JsonIgnoreProperties(value = { "password", "details_updated"})
//@Table("User")
//public record User (
//        @Id
//        Long id,
//        @NotBlank
//        String username,
//        @NotBlank
//        String password,
//        String first_name,
//        String last_name,
//        String mobile,
//        Character gender,
//        Date birth_date,
//        LocalDateTime details_updated,
//        Character user_role,
//        String profile_image
////        ,
////        Set<Cat> catSet
//){ }


// using class
@Table("User")
public record User (
        @Id
        Long id,
        @NotBlank
        String username,
        @NotBlank
        String password,
        String first_name,
        String last_name,
        String mobile,
        Character gender,
        Date birth_date,
        LocalDateTime details_updated,
        Character user_role,
        String profile_image
){}
