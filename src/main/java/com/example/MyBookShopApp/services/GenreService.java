package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.relationship.Book2Genre;
import com.example.MyBookShopApp.repository.GenreRepository;
import com.example.MyBookShopApp.services.book.BookService;
import com.example.MyBookShopApp.services.relationship.Book2GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final Book2GenreService book2GenreService;

    @Autowired
    public GenreService(GenreRepository genreRepository, Book2GenreService book2GenreService) {
        this.genreRepository = genreRepository;
        this.book2GenreService = book2GenreService;
    }

    public Genre getGenreById(Integer id){
        return genreRepository.findById(id).get();
    }

    public List<Genre> getGenres(){
        return genreRepository.findGenreByParentId(null);
    }

    public Map<String, List<Genre>> getGenresMap(){
        Map<String, List<Genre>> genreMap = new TreeMap<>();
        for (Genre mainGenre: genreRepository.findGenreByParentId(null)) {
            List<Genre> genres = new ArrayList<>();
            genres.add(mainGenre);
            genres.addAll(genreRepository.findGenreByParentId(mainGenre.getId()));
            genreMap.put(mainGenre.getName(), genres);
        }
        return genreMap;
    }

    public Genre getGenreBySlug(String slug){
        return genreRepository.findGenreBySlug(slug);
    }

    public List<Book> getBooksByGenre(Genre genre, Integer offset, Integer limit){
        List<Book> books = new ArrayList<>();
        Pageable nextPage = PageRequest.of(offset, limit);
        Logger.getAnonymousLogger().info(nextPage.toString());
        Logger.getAnonymousLogger().info(String.valueOf(book2GenreService.getBook2GenreByGenre(genre, nextPage).getContent().size()));
        if(genre.getParentId() != null) {
            for (Book2Genre book2Genre : book2GenreService.getBook2GenreByGenre(genre, nextPage).getContent())
                books.add(book2Genre.getBook());
        }else {
            for (Genre gen: genreRepository.findGenreByParentId(genre.getId()))
                for (Book2Genre book2Genre : book2GenreService.getBook2GenreByGenre(gen, nextPage).getContent())
                    books.add(book2Genre.getBook());
        }
        return books;
    }
}