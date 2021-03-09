package com.example.MyBookShopApp.repository.relationship;

import com.example.MyBookShopApp.dto.relationship.Book2Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2GenreRepository extends JpaRepository<Book2Genre, Integer> {
}
