package org.example.compulsory.services;

import org.example.compulsory.models.Author;
import org.example.compulsory.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<String> getAuthors() {
        return authorRepository.getAuthors();
    }
}
