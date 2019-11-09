package me.hosick.demojpa.post;


import me.hosick.demojpa.MyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends MyRepository<Post, Long>/*, QuerydslPredicateExecutor<Post> */{

    List<Post> findByTitleStartsWith(String title);

    @Query(value = "SELECT p FROM #{#entityName} AS p WHERE p.title = :title"/*,nativeQuery = true*/)
    List<Post> findByTitle(@Param("title")String keyword, Sort sort);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p set p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String title, Long id);
}
