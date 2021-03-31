package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.dto.GenresPageDto;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.book.BooksPageDto;
import com.example.MyBookShopApp.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


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
    @GetMapping("/{slug}")
    public String delailGenres(@PathVariable(value = "slug", required = false) String slug, Model model) {
        Genre genre = genreService.getGenreBySlug(slug);
        if(genre.getParentId() != null)
            model.addAttribute("genreParent", genreService.getGenreById(genre.getParentId()));
        model.addAttribute("genre", genre);
        model.addAttribute("genreBooks", genreService.getBooksByGenre(genre, 0, 5));
        return "genres/slug";
    }

    @GetMapping("/{slug}/1020")
    @ResponseBody
    public GenresPageDto getBookPage(@PathVariable(value = "slug", required = false) String slug,
            @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        Genre genre = genreService.getGenreBySlug(slug);
        return new GenresPageDto(genreService.getBooksByGenre(genre, offset, limit));
    }
}
