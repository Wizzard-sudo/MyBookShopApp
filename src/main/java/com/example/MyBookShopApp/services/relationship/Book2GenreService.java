package com.example.MyBookShopApp.services.relationship;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.dto.relationship.Book2Genre;
import com.example.MyBookShopApp.repository.relationship.Book2GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book2GenreService {

    private final Book2GenreRepository book2GenreRepository;

    @Autowired
    public Book2GenreService(Book2GenreRepository book2GenreRepository) {
        this.book2GenreRepository = book2GenreRepository;
    }

    public Book2Genre getBook2Genre(Integer id){
        return book2GenreRepository.findById(id).get();
    }

    public List<Book2Genre> getBook2GenreByGenre(Genre genre){
        return book2GenreRepository.findBook2GenresByGenre(genre);
    }
}
