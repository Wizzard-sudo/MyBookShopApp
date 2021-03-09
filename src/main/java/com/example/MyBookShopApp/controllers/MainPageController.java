package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.BalanceTransaction;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.services.BalanceTransactionService;
import com.example.MyBookShopApp.services.book.BookService;
import com.example.MyBookShopApp.services.relationship.Book2AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

//the controller responsible for the operation of the main page
@Controller
public class MainPageController {


    private final BookService bookService;
    private final Book2AuthorService book2AuthorService;

    @Autowired
    public MainPageController(BookService bookService, Book2AuthorService book2AuthorService) {
        this.bookService = bookService;
        this.book2AuthorService = book2AuthorService;
    }

    @ModelAttribute("recommendedBooks")
    public Map<Author, Book> recommendedBooks() {
        Map<Author, Book> books = new HashMap<>();
        for (Book book: bookService.getBookData()
             ) {
            books.put(book2AuthorService.getBook2Author(book.getId()).getAuthor(), book);
        }
        return books;
    }

    //return main page
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
