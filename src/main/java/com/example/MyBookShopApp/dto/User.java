package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.dto.book.BookReview;
import com.example.MyBookShopApp.dto.book.BookReviewLike;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String hash;
    @NotNull
    @Column(columnDefinition = "timestamp")
    private Date reg_time;
    @NotNull
    @Column(columnDefinition = "integer default 0")
    private Integer balance;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<BookReview> bookReviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<BookReviewLike> bookReviewLikes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", reg_time=" + reg_time +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
