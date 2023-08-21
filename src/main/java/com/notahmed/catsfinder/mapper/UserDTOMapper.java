package com.notahmed.catsfinder.mapper;

import com.notahmed.catsfinder.dto.CatJoinedDto;
import com.notahmed.catsfinder.dto.UserCatsJoinedDto;
import com.notahmed.catsfinder.dto.UserJoinedDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<UserCatsJoinedDto, UserJoinedDto> {


    @Override
    public UserJoinedDto apply(UserCatsJoinedDto userCatsJoinedDto) {


        UserJoinedDto user = new UserJoinedDto(
                userCatsJoinedDto.userId(),
                userCatsJoinedDto.username(),
                userCatsJoinedDto.firstName(),

                userCatsJoinedDto.lastName(),
                userCatsJoinedDto.mobile(),
                userCatsJoinedDto.gender(),
                userCatsJoinedDto.userBirthDate()
                ,null
//                ,
//                userCatsJoinedDto.stream().map(cat -> new CatJoinedDto(
//                        cat.catId(),
//                        cat.catName(),
//                        cat.catBirthDate(),
//                        null
//                )).collect(Collectors.toSet())

        );

        return user;

    }

}
