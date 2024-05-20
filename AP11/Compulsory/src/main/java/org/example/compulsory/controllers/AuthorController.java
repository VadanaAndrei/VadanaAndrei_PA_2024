package org.example.compulsory.controllers;

import org.example.compulsory.models.Author;
import org.example.compulsory.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<String> getAuthors()
    {
        return authorService.getAuthors();
    }
}
