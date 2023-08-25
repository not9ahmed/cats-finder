package com.notahmed.catsfinder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Set;

public record CatJoinedDto<comments>(

        @Id
        @JsonProperty("cat_id")
        Long catId,

        @JsonProperty("cat_name")
        String catName,

        @JsonProperty("birth_date")
        Date catBirthDate,

        @JsonProperty("owner_id")
        Long ownerId,
        // will reference comments
        Set<CommentJoinedDto>comments
) {
}
