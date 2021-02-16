package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    private final String getAuthorsSQL = "SELECT * from authors";

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


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
