package com.example.MyBookShopApp.repository.book;

import com.example.MyBookShopApp.dto.book.BookFileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileTypeRepository extends JpaRepository<BookFileType, Integer> {
}
