package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
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
}