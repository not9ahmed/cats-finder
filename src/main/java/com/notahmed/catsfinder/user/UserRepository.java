package com.notahmed.catsfinder.user;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends ListCrudRepository<User, Long> {


    //Query Derivation
//    User findUserByUsername(String username);
//
//
//
//    Boolean existsByUsername(String username);
//
//
//
//    // Query annotation for more control
//    // This works well!!
//    // N+1 Query solved
//
//    @Query("""
//            SELECT  "User"."id" AS "user_id",
//                    "User"."username" AS "username",
//                    "User"."first_name" AS "first_name",
//                    "User"."last_name" AS "last_name",
//                    "User"."mobile" AS "mobile",
//                    "User"."gender" AS "gender",
//                    "User"."birth_date" AS "user_birth_date",
//                    "Cat"."id" AS "cat_id",
//                    "Cat"."name" AS "cat_name",
//                    "Cat"."birth_date" AS "cat_birth_date"
//            FROM "User", "Cat"
//            WHERE "Cat"."owner_id" = "User".id
//            AND "User"."id" = :userId
//            """)
//    List<UserCatsJoinedDto> findUserCats(@Param("userId") Long userId);
//
//
//
//    @Query("""
//            SELECT  "User"."id" AS "user_id",
//                    "User"."username" AS "username",
//                    "User"."first_name" AS "first_name",
//                    "User"."last_name" AS "last_name",
//                    "User"."mobile" AS "mobile",
//                    "User"."gender" AS "gender",
//                    "User"."birth_date" AS "user_birth_date",
//                    "Cat"."id" AS "cat_id",
//                    "Cat"."name" AS "cat_name",
//                    "Cat"."birth_date" AS "cat_birth_date",
//                    "Comment"."id" AS "comment_id",
//                    "Comment"."name" AS "comment_name",
//                    "Comment"."content" AS "comment_content",
//                    "Comment"."published_on" AS "comment_published_on",
//                    "Comment"."updated_on" AS "comment_updated_on"
//            FROM "User"
//            FULL OUTER JOIN "Cat"
//            ON "User"."id" = "Cat"."owner_id"
//            FULL OUTER JOIN "Comment"
//            ON "Cat"."id" = "Comment"."cat"
//
//            """)
//    List<UserCatsCommentsJoinedDto> findAllUsersCatsAndComments();





    // three joins user, cats and comments
//    @Query("""
//            SELECT  "User"."id" AS "user_id",
//                    "User"."username" AS "username",
//                    "User"."first_name" AS "first_name",
//                    "User"."last_name" AS "last_name",
//                    "User"."mobile" AS "mobile",
//                    "User"."gender" AS "gender",
//                    "User"."birth_date" AS "user_birth_date",
//                    "Cat"."id" AS "cat_id",
//                    "Cat"."name" AS "cat_name",
//                    "Cat"."birth_date" AS "cat_birth_date",
//                    "Comment"."id" AS "comment_id",
//                    "Comment"."name" AS "comment_name",
//                    "Comment"."content" AS "comment_content",
//                    "Comment"."published_on" AS "comment_published_on",
//                    "Comment"."updated_on" AS "comment_updated_on"
//            FROM "User"
//            FULL OUTER JOIN "Cat"
//            ON "User"."id" = "Cat"."owner_id"
//            FULL OUTER JOIN "Comment"
//            ON "Cat"."id" = "Comment"."cat"
//            WHERE "User"."id" = :userId
//            ORDER BY "User"."id"
//            """)
//    List<UserCatsCommentsJoinedDto> findUserCatsAndComments(@Param("userId") Long userId);


}
