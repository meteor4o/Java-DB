package com.springdata.exercises.repositories;

import com.springdata.exercises.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Java Persistence Query Language
    @Query("select a from Author a order by a.books.size desc")
    List<Author> findAllAuthorByCountOfBook();
    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);


    List<Author> findAllByFirstNameLike(String firstName);
}