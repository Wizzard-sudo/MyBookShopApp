package com.example.MyBookShopApp.repository.book;

import com.example.MyBookShopApp.dto.book.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {
}
