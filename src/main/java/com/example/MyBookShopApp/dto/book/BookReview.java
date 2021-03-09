package com.example.MyBookShopApp.dto.book;

import com.example.MyBookShopApp.dto.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book_reviews")
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @NotNull
    @Column(columnDefinition = "timestamp")
    private Date time;
    @NotNull
    @Column(columnDefinition = "text")
    private String text;

    @OneToMany(mappedBy = "bookReview")
    private List<BookReviewLike> bookReviewLikes = new ArrayList<>();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", time=" + time +
                ", text='" + text + '\'' +
                '}';
    }
}
