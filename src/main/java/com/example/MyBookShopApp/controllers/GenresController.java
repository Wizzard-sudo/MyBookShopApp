package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//the controller responsible for working with book genres
@Controller
@RequestMapping("/genres")
public class GenresController {

    //return main genres page
    @GetMapping("/")
    public String genresPage() {
        return "genres/index";
    }

    //return detail genres page
    @GetMapping("/slug")
    public String delailGenres() {
        return "genres/slug";
    }
}
