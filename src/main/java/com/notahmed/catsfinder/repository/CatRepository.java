package com.notahmed.catsfinder.repository;

import com.notahmed.catsfinder.models.Cat;
import org.springframework.data.repository.ListCrudRepository;

public interface CatRepository extends ListCrudRepository<Cat, Long> {
}


//package com.notahmed.contentcalendar.repository;
//
//        import com.notahmed.contentcalendar.models.Content;
//        import com.notahmed.contentcalendar.models.Status;
//        import org.springframework.data.jdbc.repository.query.Query;
//        import org.springframework.data.repository.ListCrudRepository;
//        import org.springframework.data.repository.query.Param;
//
//        import java.util.List;
//
//// By extending the interface at runtime I will get all the methods and properties of that interface
//public interface ContentRepository extends ListCrudRepository<Content, Integer> {
//
//    // this will converted to query at runtime
//    List<Content> findAllByTitleContains(String keyword);
//
//
//    @Query("""
//            SELECT *
//            FROM CONTENT
//            WHERE status = :status
//            """)
//    List<Content> listByStatus(@Param("status") Status status);
//}
