package com.notahmed.catsfinder.dto;

import java.time.LocalDateTime;
import java.util.Date;

public record UserCatsCommentsJoinedDto(

        Long userId,
        String username,
        String firstName,
        String lastName,
        String mobile,
        Character gender,
        Date userBirthDate,
        Long catId,
        String catName,
        Date catBirthDate,
        Long commentId,
        String commentName,
        String commentContent,
        LocalDateTime commentPublishedOn,
        LocalDateTime commentUpdatedOn
) {
}
