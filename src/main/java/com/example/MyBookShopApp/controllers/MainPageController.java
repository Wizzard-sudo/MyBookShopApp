package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.book.BooksPageDto;
import com.example.MyBookShopApp.services.book.BookService;
import com.example.MyBookShopApp.services.relationship.Book2AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
    public List<Book> recommendedBooks() {
        return bookService.getPageOfRecommendedBooks(0, 6).getContent();
    }

    @ModelAttribute("newsBooks")
    public List<Book> newsBooks() {
        return bookService.getPageOfNewsBooks(0, 6).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return bookService.getPageOfPopularBooks(0, 6).getContent();
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

    @GetMapping("/books/mainRecent")
    @ResponseBody
    public BooksPageDto getNewsBookPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit,
                                        @RequestParam(value = "from", defaultValue = "2000-01-01") String from,
                                        @RequestParam(value = "to", defaultValue = "2022-01-01") String to){
        if(from.equals("2000-01-01") & to.equals("2022-01-01")){
            Logger.getAnonymousLogger().info("auto date");
            return new BooksPageDto(bookService.getPageOfNewsBooks(offset, limit).getContent());
        }else {
            return new BooksPageDto(bookService.getPageOfNewsBooks(offset, limit, from, to).getContent());
        }
    }

    @GetMapping("/books/mainPopular")
    @ResponseBody
    public BooksPageDto getPopularBookPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfPopularBooks(offset, limit).getContent());
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
