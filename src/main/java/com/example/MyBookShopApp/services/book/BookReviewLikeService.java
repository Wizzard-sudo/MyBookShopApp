package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.book.BookReviewLike;
import com.example.MyBookShopApp.repository.book.BookReviewLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReviewLikeService {

    private BookReviewLikeRepository bookReviewLikeRepository;

    @Autowired
    public BookReviewLikeService(BookReviewLikeRepository bookReviewLikeRepository) {
        this.bookReviewLikeRepository = bookReviewLikeRepository;
    }

    public BookReviewLike getBookReviewLikeById(Integer id){
        return bookReviewLikeRepository.findById(id).get();
    }
}
