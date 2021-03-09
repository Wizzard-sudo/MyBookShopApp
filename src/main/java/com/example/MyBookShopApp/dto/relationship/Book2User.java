package com.example.MyBookShopApp.dto.relationship;

import com.example.MyBookShopApp.dto.user.User;
import com.example.MyBookShopApp.dto.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "book2user")
public class Book2User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = "timestamp")
    private Date time;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Book2UserType book2UserType;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Book2UserType getBook2UserType() {
        return book2UserType;
    }

    public void setBook2UserType(Book2UserType book2UserType) {
        this.book2UserType = book2UserType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book2User{" +
                "id=" + id +
                ", time=" + time +
                ", book2UserType=" + book2UserType +
                ", book=" + book +
                ", user=" + user +
                '}';
    }
}