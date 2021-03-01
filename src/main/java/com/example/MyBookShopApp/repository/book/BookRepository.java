package com.example.MyBookShopApp.repository.book;

import com.example.MyBookShopApp.dto.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("from Book")
    List<Book> customFindAllBooks();
}
