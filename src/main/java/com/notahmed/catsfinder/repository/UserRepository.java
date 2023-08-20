package com.notahmed.catsfinder.repository;

import com.notahmed.catsfinder.dto.CatDetailsNew;
import com.notahmed.catsfinder.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends ListCrudRepository<User, Long> {


    User findUserByUsername(String username);

    Boolean existsByUsername(String username);


    @Query("""
            SELECT *
            FROM "User", "Cat", "Comment"
            WHERE "Cat".owner_id = "User".id
            AND "Cat".id = "Comment".cat
            AND "User".id = :userId
            LIMIT 1
            """)
    User findUserCatsAndComments(@Param("userId") Long userId);

}
