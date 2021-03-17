package com.example.MyBookShopApp.dto.user;

import com.example.MyBookShopApp.dto.BalanceTransaction;
import com.example.MyBookShopApp.dto.FileDownload;
import com.example.MyBookShopApp.dto.book.BookReview;
import com.example.MyBookShopApp.dto.book.BookReviewLike;
import com.example.MyBookShopApp.dto.communication.Message;
import com.example.MyBookShopApp.dto.relationship.Book2User;

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
    @Column(name = "reg_time", columnDefinition = "timestamp")
    private Date regTime;
    @NotNull
    @Column(columnDefinition = "integer default 0")
    private Integer balance;
    private String name;

    @OneToOne(mappedBy = "user")
    private UserContact userContact;

    @OneToMany(mappedBy = "user")
    private List<BookReview> bookReviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<BookReviewLike> bookReviewLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Book2User> book2Users = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<BalanceTransaction> balanceTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<FileDownload> fileDownloads = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

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

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
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
                ", reg_time=" + regTime +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
