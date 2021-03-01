package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.book.BookReview;
import com.example.MyBookShopApp.repository.book.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReviewService {

    private final BookReviewRepository bookReviewRepository;

    @Autowired
    public BookReviewService(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    public BookReview getBookReviewById(Integer id){
        return bookReviewRepository.findById(id).get();
    }
}
