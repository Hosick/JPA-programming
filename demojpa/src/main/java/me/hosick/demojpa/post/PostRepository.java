package me.hosick.demojpa.post;


import me.hosick.demojpa.MyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {

    List<Post> findByTitleStartsWith(String title);

    @Query(value = "SELECT p FROM #{#entityName} AS p WHERE p.title = :title"/*,nativeQuery = true*/)
    List<Post> findByTitle(@Param("title")String keyword, Sort sort);
}
