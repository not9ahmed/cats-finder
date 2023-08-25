package com.notahmed.catsfinder.mapper;

import com.notahmed.catsfinder.dto.CatJoinedDto;
import com.notahmed.catsfinder.dto.CommentJoinedDto;
import com.notahmed.catsfinder.dto.UserCatsCommentsJoinedDto;
import com.notahmed.catsfinder.dto.UserJoinedDto;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserCatsMapper {


    public static UserJoinedDto mapUserCat(List<UserCatsCommentsJoinedDto> userCatsCommentsJoinedDtos) {

        Map<Long, Set<CommentJoinedDto>> commentsMap =
                userCatsCommentsJoinedDtos.stream().filter(row -> userCatsCommentsJoinedDtos.size() > 2).map(row -> new CommentJoinedDto(
                                row.commentId(),
                                row.catId(),
                                row.commentName(),
                                row.commentContent(),
                                row.commentPublishedOn(),
                                row.commentUpdatedOn()))
                        .collect(Collectors.groupingBy(CommentJoinedDto::cat,Collectors.toSet()));

        System.out.println("commentsMap");
        System.out.println(commentsMap);


        // mapping the cats to owner
        Map<Long, Set<CatJoinedDto>> catsMap = userCatsCommentsJoinedDtos.stream().map(row -> new CatJoinedDto(
                row.catId(),
                row.catName(),
                row.catBirthDate(),
                row.userId(),
                commentsMap.get(row.catId())
        )).collect(Collectors.groupingBy(CatJoinedDto::ownerId, Collectors.toSet()));




        // map catMap to owner

        UserJoinedDto user = userCatsCommentsJoinedDtos.stream().findAny().map(row -> new UserJoinedDto(
                row.userId(),
                row.username(),
                row.firstName(),
                row.lastName(),
                row.mobile(),
                row.gender(),
                row.userBirthDate(),
                catsMap.get(row.userId())
        )).orElse(null);




        return user;
    }
}
