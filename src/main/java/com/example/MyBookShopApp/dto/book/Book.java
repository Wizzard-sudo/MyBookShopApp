package com.example.MyBookShopApp.dto.book;

import com.example.MyBookShopApp.dto.BalanceTransaction;
import com.example.MyBookShopApp.dto.FileDownload;
import com.example.MyBookShopApp.dto.relationship.Book2Author;
import com.example.MyBookShopApp.dto.relationship.Book2Genre;
import com.example.MyBookShopApp.dto.relationship.Book2User;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Date pub_date;
    @NotNull
    private short is_bestseller;
    @NotNull
    private String slug;
    @NotNull
    private String title;
    private String image;
    @Column(columnDefinition = "text")
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    @Column(columnDefinition = "smallint default 0")
    private short discount;

    @OneToMany(mappedBy = "book")
    private List<Book2Author> book2Author = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BookReview> bookReviews = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Book2Genre> book2Genres = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Book2User> book2Users = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BalanceTransaction> balanceTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<FileDownload> fileDownloads = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public short getIs_bestseller() {
        return is_bestseller;
    }

    public void setIs_bestseller(short is_bestseller) {
        this.is_bestseller = is_bestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", pub_date=" + pub_date +
                ", is_bestseller=" + is_bestseller +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
