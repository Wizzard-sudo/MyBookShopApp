package com.example.MyBookShopApp.repository.book;

import com.example.MyBookShopApp.dto.book.BookFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileRepository extends JpaRepository<BookFile, Integer> {
}
