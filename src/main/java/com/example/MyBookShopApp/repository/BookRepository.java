package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Book;

import java.util.List;

//the interface that is responsible for all the operations with the authors
public interface BookRepository {

    //returns all books from the database in array
    public List<Book> getBookData();
}
