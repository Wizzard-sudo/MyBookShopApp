package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{

    private final JdbcTemplate jdbcTemplate;

    //SQL query for getting all authors from the database
    private final String getAuthorsSQL = "SELECT * from authors";

    @Autowired
    public AuthorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query(getAuthorsSQL, (ResultSet rs, int rowNum)->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_Name"));
            author.setLastName(rs.getString("last_Name"));
            return author;
        });
        return authors.stream().collect(Collectors.groupingBy((Author a) -> {return a.getLastName().substring(0, 1);}));
    }

}
