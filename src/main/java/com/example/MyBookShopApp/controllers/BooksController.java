package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//the controller responsible for working with books
@Controller
@RequestMapping("/books")
public class BooksController {

    //return page with news books
    @GetMapping("/recent")
    public String recentPage() {
        return "books/recent";
    }

    //return page with popular books
    @GetMapping("/popular")
    public String popularPage() {
        return "books/popular";
    }
}
