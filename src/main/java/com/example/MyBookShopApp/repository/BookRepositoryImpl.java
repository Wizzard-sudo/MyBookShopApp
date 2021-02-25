package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    //SQL query for getting all books from the database
    private final String getAllBooksSQL = "SELECT * FROM books";

    //SQL query for getting all authors info with id from the database
    private final String getAuthorSQL = "SELECT * FROM authors WHERE authors.id =";

    @Autowired
    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getBookData() {
        List<Book> books = jdbcTemplate.query(getAllBooksSQL, (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(getAuthorByAuthorId(rs.getInt("author_id")));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    private String getAuthorByAuthorId(int author_id) {
        List<Author> authors = jdbcTemplate.query(getAuthorSQL + author_id, (ResultSet rs, int rowNum) ->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return authors.get(0).toString();
    }
}
