package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.dto.book.Book;

import java.util.List;

public class GenresPageDto {

    private Integer count;
    private List<Book> genres;

    public GenresPageDto(List<Book> genres) {
        this.genres = genres;
        this.count = genres.size();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Book> getGenres() {
        return genres;
    }

    public void setGenres(List<Book> genres) {
        this.genres = genres;
    }
}
