package com.example.MyBookShopApp.repository.relationship;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.relationship.Book2Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface Book2AuthorRepository extends JpaRepository<Book2Author, Integer> {

    public Page<Book2Author> findBook2AuthorsByAuthor(@NotNull Author author, Pageable pageable);
}
