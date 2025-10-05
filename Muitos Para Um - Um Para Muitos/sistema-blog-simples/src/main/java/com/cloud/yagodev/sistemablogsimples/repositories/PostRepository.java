package com.cloud.yagodev.sistemablogsimples.repositories;

import com.cloud.yagodev.sistemablogsimples.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
           select p
           from Post p
           join fetch p.autor
           """)
    List<Post> findAllWithAutor();
}
