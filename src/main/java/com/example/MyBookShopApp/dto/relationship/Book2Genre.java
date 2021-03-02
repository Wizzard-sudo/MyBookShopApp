package com.example.MyBookShopApp.dto.relationship;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.dto.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book2genre")
public class Book2Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book2Genre{" +
                "id=" + id +
                ", book=" + book +
                ", genre=" + genre +
                '}';
    }
}
