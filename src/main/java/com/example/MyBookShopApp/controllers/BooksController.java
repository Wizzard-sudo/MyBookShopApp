package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    @GetMapping("/recent")
    public String recentPage(){
        return "books/recent";
    }

    @GetMapping("/popular")
    public String popularPage(){
        return "books/popular";
    }
}
