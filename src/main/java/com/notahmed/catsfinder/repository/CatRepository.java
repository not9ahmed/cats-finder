package com.notahmed.catsfinder.repository;

import com.notahmed.catsfinder.models.Cat;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatRepository extends ListCrudRepository<Cat, Long> {


    List<Cat> findAllByOwnerId(Long id);

    @Query("""
            SELECT "Cat".id, "Cat".name,"Cat"owner_id,Breed breed_id,owner_id,birth_date,images,toys
            FROM "Cat", "User", "Breed"
            WHERE "User".id = "Cat".owner_id
            AND "Cat".breed_id = "Breed".id
            """)
    List<Cat> findAllCatJoinUser();


    @Modifying
    @Query("""
            DELETE FROM "Comment"
            WHERE "Comment".cat = :cat
            AND "Comment".name = :name
            AND "Comment".content = :content
            """)
    void deleteComment(@Param("cat") Long cat, @Param("name") String name, @Param("content") String content);


}
