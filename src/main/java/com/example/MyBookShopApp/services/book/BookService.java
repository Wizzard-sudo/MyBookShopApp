package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//the service responsible for the operation and processing of books
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //returns all books from the database
    public List<Book> getBookData() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id){ return bookRepository.findById(id).get();}

}
