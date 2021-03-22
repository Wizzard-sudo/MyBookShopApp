package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.book.BooksPageDto;
import com.example.MyBookShopApp.services.book.BookService;
import com.example.MyBookShopApp.services.relationship.Book2AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//the controller responsible for the operation of the main page
@Controller
public class MainPageController {


    private final BookService bookService;
    private final Book2AuthorService book2AuthorService;

    @Autowired
    public MainPageController(BookService bookService, Book2AuthorService book2AuthorService) {
        this.bookService = bookService;
        this.book2AuthorService = book2AuthorService;
    }

    @ModelAttribute("recommendedBooks")
    public Map<Author, Book> recommendedBooks() {
        Map<Author, Book> books = new HashMap<>();
        for (Book book: bookService.getPageOfRecommendedBooks(0, 6).getContent()) {
            books.put(book2AuthorService.getBook2Author(book.getId()).getAuthor(), book);
        }
        return books;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    //return main page
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBookPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
    }

    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                   Model model) {
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults",
                bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), 0, 5).getContent());
        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto) {
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent());
    }
}
