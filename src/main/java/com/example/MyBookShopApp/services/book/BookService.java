package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.repository.book.BookRepository;
import com.example.MyBookShopApp.services.relationship.Book2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

//the service responsible for the operation and processing of books
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final Book2UserService book2UserService;

    @Autowired
    public BookService(BookRepository bookRepository, Book2UserService book2UserService) {
        this.bookRepository = bookRepository;
        this.book2UserService = book2UserService;
    }

    //returns all books from the database
    public List<Book> getBookData() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id){ return bookRepository.findById(id).get();}

    //NEW BOOK REST SERVICE METHOD

//    public List<Book> getBooksByAuthors(String authorName){
//        return bookRepository.findBooksByAuthorNameContaining(authorName);
//    }

    public List<Book> getBooksByTitle(String bookTitle){
        return bookRepository.findBooksByTitleContaining(bookTitle);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceBetween(min, max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepository.findBooksByPriceIs(price);
    }

    public List<Book> getBookWithMaxDiscount(){
        return bookRepository.getBooksByMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookRepository.getBestsellers();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfNewsBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("pubDate").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("popular").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBookByTitleContaining(searchWord, nextPage);
    }
}
