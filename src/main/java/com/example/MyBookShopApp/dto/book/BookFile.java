package com.example.MyBookShopApp.dto.book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book_file")
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String hash;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private BookFileType bookFileType;
    @NotNull
    private String path;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public String getBookFileExtensionString(){
        return BookFileTypeEnum.getExtensionStringByTypeId(bookFileType.getId());
    }

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

    public BookFileType getBookFileType() {
        return bookFileType;
    }

    public void setBookFileType(BookFileType bookFileType) {
        this.bookFileType = bookFileType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookFile{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", bookFileType=" + bookFileType +
                ", path='" + path + '\'' +
                '}';
    }
}
