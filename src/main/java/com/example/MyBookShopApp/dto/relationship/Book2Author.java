package com.example.MyBookShopApp.dto.relationship;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.book.Book;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "book2author")
public class Book2Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @NotNull
    @Column(columnDefinition = "integer default 0")
    private Integer sort_index;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getSort_index() {
        return sort_index;
    }

    public void setSort_index(Integer sort_index) {
        this.sort_index = sort_index;
    }

    @Override
    public String toString() {
        return "Book2Author{" +
                "id=" + id +
                ", book=" + book +
                ", author=" + author +
                ", sort_index=" + sort_index +
                '}';
    }
}
