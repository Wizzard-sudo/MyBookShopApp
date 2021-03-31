package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//the service responsible for the work and processing of authors
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //returns all authors from the database, in the form "*letter*, *array of authors*"
    public Map<String, List<Author>> getAuthorsMap() {
        return authorRepository.findAll().stream().collect(Collectors.groupingBy((Author a) -> a.getName().substring(0, 1)));
    }

    public Author getAuthorById(Integer id){
        return authorRepository.findById(id).get();
    }

    public Author getAuthorBySlug(String slug){
        return authorRepository.findAuthorBySlug(slug);
    }
}
