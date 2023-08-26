package com.notahmed.catsfinder.mapper;

import com.notahmed.catsfinder.dto.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper {


    public UserJoinedDto mapUserCat(List<UserCatsCommentsJoinedDto> userCatsCommentsJoinedDtos) {


        if (userCatsCommentsJoinedDtos.size() == 0) {
            return null;
        }

        Map<Long, Set<CommentJoinedDto>> commentsMap =
                userCatsCommentsJoinedDtos
                        .stream()
                        .filter(row -> row.commentId() != null)
                        .filter(row -> userCatsCommentsJoinedDtos.size() > 2)
                        .map(row -> new CommentJoinedDto(
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
        Map<Long, Set<CatJoinedDto>> catsMap =
                userCatsCommentsJoinedDtos.stream()
                        .filter(row -> row.catId() != null)
                        .map(row -> new CatJoinedDto(
                            row.catId(),
                            row.catName(),
                            row.catBirthDate(),
                            row.userId(),
                            commentsMap.get(row.catId())
                    )).collect(Collectors.groupingBy(CatJoinedDto::ownerId, Collectors.toSet()));




        // map catMap to owner

        UserJoinedDto user = userCatsCommentsJoinedDtos.stream()
                .findAny()
                .map(row -> new UserJoinedDto(
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



    public List<UserJoinedDto> mapUsersCatList(List<UserCatsCommentsJoinedDto> userCatsCommentsJoinedDtos) {

        Map<Long, Set<CommentJoinedDto>> commentsMap =
                userCatsCommentsJoinedDtos.stream().filter(row -> userCatsCommentsJoinedDtos.size() > 2)
                        .filter(row -> row.commentId() != null)
                        .map(row -> new CommentJoinedDto(
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
        Map<Long, Set<CatJoinedDto>> catsMap =
                userCatsCommentsJoinedDtos.stream()
                    .filter(row -> row.catId() != null)
                    .map(row -> new CatJoinedDto(
                        row.catId(),
                        row.catName(),
                        row.catBirthDate(),
                        row.userId(),
                        commentsMap.get(row.catId())
                    ))
                    .collect(Collectors.groupingBy(CatJoinedDto::ownerId, Collectors.toSet()));


        System.out.println("catsMap");
        System.out.println(catsMap);




        List<UserJoinedDto> usersList =
                userCatsCommentsJoinedDtos.stream().map(row -> new UserJoinedDto(
                        row.userId(),
                        row.username(),
                        row.firstName(),
                        row.lastName(),
                        row.mobile(),
                        row.gender(),
                        row.userBirthDate(),
                        catsMap.get(row.userId())
                ))
                .sorted(Comparator.comparing(UserJoinedDto::userId))
                .distinct()
                .collect(Collectors.toList());


        System.out.println("usersList");
        usersList.forEach(System.out::println);

        return usersList;
    }





    public UserJoinedDto mapToUserJoinedDto(List <UserCatsJoinedDto> userCats){


//        Set<CatJoinedDto> cats = userCats.stream().map(cat -> new CatJoinedDto(
//                cat.catId(),
//                cat.catName(),
//                cat.catBirthDate(),
//                null
//        )).collect(Collectors.toSet());


        UserJoinedDto user = new UserJoinedDto(
                userCats.get(0).userId(),
                userCats.get(0).username(),
                userCats.get(0).firstName(),

                userCats.get(0).lastName(),
                userCats.get(0).mobile(),
                userCats.get(0).gender(),
                userCats.get(0).userBirthDate(),
                userCats.stream().map(cat -> new CatJoinedDto(
                        cat.catId(),
                        cat.catName(),
                        cat.catBirthDate(),
                        null,
                        null
                )).collect(Collectors.toSet())

        );

        return user;


    }
}
