package com.notahmed.catsfinder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notahmed.catsfinder.models.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Date;
import java.util.Set;

public record UserJoinedDto(
        @Id
        @JsonProperty("user_id")
        Long userId,
        String username,

        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,
        String mobile,
        Character gender,

        @JsonProperty("birth_date")
        Date birthDate,

//        @MappedCollection(keyColumn = "id", idColumn = "cat")
        Set<CatJoinedDto> cats
) {
}