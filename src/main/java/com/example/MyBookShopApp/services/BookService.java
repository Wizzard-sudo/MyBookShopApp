package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.Book;
import com.example.MyBookShopApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//the service responsible for the operation and processing of books
@Service
public class BookService {

    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    //returns all books from the database
    public List<Book> getBookData() {
        return bookRepo.getBookData();
    }
}
