package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Author;

import java.util.List;
import java.util.Map;

//the interface that is responsible for all the operations with the authors
public interface AuthorRepository {

    //returns all authors from the database, in the form "*letter*, *array of authors*"
    public Map<String, List<Author>> getAuthorsMap();

}
