package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

//the controller responsible for the operation of the main page
@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    //return Model with recommended Books
    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getBookData();
    }

    //return main page
    @GetMapping("/")
    public String mainPage(){
        return "index";
    }
}
