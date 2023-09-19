package com.notahmed.catsfinder.dto;

import java.time.LocalDateTime;
import java.util.Date;

// No need for this I should handle the mapping directly in terms of loop and using the mapRow
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
