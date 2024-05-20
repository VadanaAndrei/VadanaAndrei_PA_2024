package org.example.compulsory.repositories;

import org.example.compulsory.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Integer>{

    @Query(value = "select name from authors", nativeQuery = true)
    List<String> getAuthors();
}
