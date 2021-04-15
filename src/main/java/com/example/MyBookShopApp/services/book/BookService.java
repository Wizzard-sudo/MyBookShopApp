package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.relationship.Book2Author;
import com.example.MyBookShopApp.errors.BookstoreApiWrongParameterException;
import com.example.MyBookShopApp.repository.book.BookRepository;
import com.example.MyBookShopApp.services.relationship.Book2AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//the service responsible for the operation and processing of books
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final Book2AuthorService book2AuthorService;

    @Autowired
    public BookService(BookRepository bookRepository, Book2AuthorService book2AuthorService) {
        this.bookRepository = bookRepository;
        this.book2AuthorService = book2AuthorService;
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

    public List<Book> getBooksByTitle(String bookTitle) throws BookstoreApiWrongParameterException {
        if(bookTitle.equals("") || bookTitle.length() <= 1){
            throw new BookstoreApiWrongParameterException("Wrong values passed to one or more parameters");
        }else {
            List<Book> data = bookRepository.findBooksByTitleContaining(bookTitle);
            if (data.size() > 0){
                return data;
            }else {
                throw new BookstoreApiWrongParameterException("No data found with specified parameters...");
            }
        }
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

    public Book getBookBySlug(String slug){return bookRepository.findBookBySlug(slug);}

    public Book saveBook(Book book){ return bookRepository.save(book);}

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfNewsBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("pubDate").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfNewsBooks(Integer offset, Integer limit, String from, String to){
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("pubDate").descending());
        String newFrom = from.substring(6, 10) + "-" + from.substring(3, 5) + "-" + from.substring(0, 2);
        String newTo = to.substring(6, 10) + "-" + to.substring(3, 5) + "-" + to.substring(0, 2);
        return bookRepository.findBooksByPubDateBetween(Date.valueOf(newFrom), Date.valueOf(newTo), nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit, Sort.by("popular").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBookByTitleContaining(searchWord, nextPage);
    }

    public List<Book> getPageBooksByAuthor(Author author, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        Page<Book2Author> book2Authors = book2AuthorService.getBook2AuthorsByAuthor(author, nextPage);
        List<Book> books = new ArrayList<>();
        for (Book2Author book2Author: book2Authors) {
            books.add(book2Author.getBook());
        }
        if(books.size() < 5)
            for(int i = 0; i < 5 - books.size(); i++)
                books.add(books.get(0));
        return books;
    }
}
