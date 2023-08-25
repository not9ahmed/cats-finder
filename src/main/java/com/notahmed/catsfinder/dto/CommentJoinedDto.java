package com.notahmed.catsfinder.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record CommentJoinedDto(

        @Id
        Long id,


        Long cat,

        String name,
        String content,
        LocalDateTime publishedOn,
        LocalDateTime updatedOn
) {
}
