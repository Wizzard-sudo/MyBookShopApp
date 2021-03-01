package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

//the controller responsible for the operation of the main page
@Controller
public class MainPageController {

    private GenreService service;

    @Autowired
    public MainPageController(GenreService service) {
        this.service = service;
    }

//    private final BookService bookService;
//
//    public MainPageController(BookService bookService) {
//        this.bookService = bookService;
//    }

    //return Model with recommended Books
//    @ModelAttribute("recommendedBooks")
//    public List<Book> recommendedBooks() {
//        return bookService.getBookData();
//    }

    //return main page
    @GetMapping("/")
    public String mainPage() {
        Genre genre = service.getGenreById(1);
        Logger.getAnonymousLogger().info(genre.toString());
        return "index";
    }
}
