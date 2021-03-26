package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.book.BooksPageDto;
import com.example.MyBookShopApp.services.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

//the controller responsible for working with books
@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("newsBooks")
    public List<Book> newsBooks() {
        return bookService.getPageOfNewsBooks(0, 20).getContent();
    }

//    @GetMapping("/books/mainRecent")
//    @ResponseBody
//    public BooksPageDto getNewsBookPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit,
//                                        @RequestParam("from") Date from, @RequestParam("to") Date to){
//        return new BooksPageDto(bookService.getPageOfNewsBooks(offset, limit).getContent());
//    }

    //return page with news books
    @GetMapping("/recent")
    public String recentPage() {
        return "books/recent";
    }

    //return page with popular books
    @GetMapping("/popular")
    public String popularPage() {
        return "books/popular";
    }
}
