package com.example.MyBookShopApp.repository.relationship;

import com.example.MyBookShopApp.dto.Genre;
import com.example.MyBookShopApp.dto.relationship.Book2Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface Book2GenreRepository extends JpaRepository<Book2Genre, Integer> {

    public List<Book2Genre> findBook2GenresByGenre(@NotNull Genre genre);
}
