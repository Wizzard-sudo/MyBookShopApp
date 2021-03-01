package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Book2Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2AuthorRepository extends JpaRepository<Book2Author, Integer> {
}
