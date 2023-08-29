package com.notahmed.catsfinder.dto;

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
