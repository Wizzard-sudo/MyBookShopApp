package com.example.MyBookShopApp.restControllers;

import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.services.book.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "book data api")
public class BooksRestApiController {

    private final BookService bookService;

    @Autowired
    public BooksRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/books/by-author")
//    @ApiOperation("operation to get book lis of bookshop by passed author")
//    public ResponseEntity<List<Book>> booksByAuthor(@RequestParam("author") String authorName){
//        return ResponseEntity.ok(bookService.getBooksByAuthors(authorName));
//    }

    @GetMapping("/books/by-title")
    @ApiOperation("get books by book title")
    public ResponseEntity<List<Book>> booksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    @ApiOperation("get books by price range from min price to max price")
    public ResponseEntity<List<Book>> priceRangeBooks(@RequestParam("min") Integer min, @RequestParam("max") Integer max){
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min, max));
    }

    @GetMapping("/books/with-max-discount")
    @ApiOperation("get books by max discount")
    public ResponseEntity<List<Book>> maxDiscountBooks(){
        return ResponseEntity.ok(bookService.getBookWithMaxDiscount());
    }

    @GetMapping("books/bestseller")
    @ApiOperation("get bestseller books (with is_bestseller = 1)")
    public ResponseEntity<List<Book>> bestsellerBooks(){
        return ResponseEntity.ok(bookService.getBestsellers());
    }
}
