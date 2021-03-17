package com.example.MyBookShopApp.dto.book;

import com.example.MyBookShopApp.dto.BalanceTransaction;
import com.example.MyBookShopApp.dto.FileDownload;
import com.example.MyBookShopApp.dto.relationship.Book2Author;
import com.example.MyBookShopApp.dto.relationship.Book2Genre;
import com.example.MyBookShopApp.dto.relationship.Book2User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
@ApiModel(description = "entity representing a book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generated by db automatically")
    private Integer id;
    @NotNull
    @Column(name = "pub_date")
    @ApiModelProperty("date of book publication")
    private Date pubDate;
    @NotNull
    @Column(name = "is_bestseller")
    @ApiModelProperty("if isBestseller = 1 so the book is considered to be bestseller")
    private Integer isBestseller;
    @NotNull
    @ApiModelProperty("mnemonically identity sequence of charters")
    private String slug;
    @NotNull
    @ApiModelProperty("book title")
    private String title;
    @ApiModelProperty("book image")
    private String image;
    @Column(columnDefinition = "text")
    @ApiModelProperty("book description text")
    private String description;
    @NotNull
    @ApiModelProperty("book price without discount")
    private Integer price;
    @NotNull
    @Column(columnDefinition = "smallint default 0")
    @ApiModelProperty("book discount value from book")
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

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
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
                ", pub_date=" + pubDate +
                ", is_bestseller=" + isBestseller +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
