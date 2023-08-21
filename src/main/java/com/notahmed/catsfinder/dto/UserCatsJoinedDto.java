package com.notahmed.catsfinder.dto;

import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public record UserCatsJoinedDto (

        Long userId,
        String username,
        String firstName,
        String lastName,
        String mobile,
        Character gender,
        Date userBirthDate,
        Long catId,
        String catName,
        Date catBirthDate

){
}
