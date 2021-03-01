package com.example.MyBookShopApp.repository.book;

import com.example.MyBookShopApp.dto.book.BookReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewLikeRepository extends JpaRepository<BookReviewLike, Integer> {
}
