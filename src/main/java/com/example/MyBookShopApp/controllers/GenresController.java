package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


//the controller responsible for working with book genres
@Controller
@RequestMapping("/genres")
public class GenresController {

    private final GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @ModelAttribute("genresName")
    public Map<String, List<Genre>> getGenres(){
        return genreService.getGenresMap();
    }

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
