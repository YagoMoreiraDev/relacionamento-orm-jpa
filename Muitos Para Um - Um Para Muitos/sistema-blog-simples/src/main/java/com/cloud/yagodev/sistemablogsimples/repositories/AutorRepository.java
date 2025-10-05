package com.cloud.yagodev.sistemablogsimples.repositories;

import com.cloud.yagodev.sistemablogsimples.model.Autor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    /**
     * Busca um Autor pelo seu ID e carrega sua lista de posts na mesma consulta
     * para evitar o problema de N+1 e a LazyInitializationException.
     * O "JOIN FETCH a.posts" é a chave aqui.
     */
    @Query("SELECT a FROM Autor a JOIN FETCH a.posts WHERE a.id = :id")
    Optional<Autor> findByIdWithPosts(@Param("id") Long id);

    /**
     * Busca os Autores de uma lista específica e carrega seus posts.
     * Isso será usado como a segunda query para evitar o problema N+1.
     */
    @Query("SELECT DISTINCT a FROM Autor a LEFT JOIN FETCH a.posts WHERE a IN :autores")
    List<Autor> findAutoresWithPosts(List<Autor> autores);
}
