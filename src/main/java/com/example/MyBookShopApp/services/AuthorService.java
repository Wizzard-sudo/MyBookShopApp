package com.example.MyBookShopApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    private final String getAuthorsSQL = "SELECT author from authors";

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getAuthors(){
        List<String> authors = jdbcTemplate.query(getAuthorsSQL, (ResultSet rs, int rowNum) -> rs.getString("author"));
        return new ArrayList<>(authors);
    }
}