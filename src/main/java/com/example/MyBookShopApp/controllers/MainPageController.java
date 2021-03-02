package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.relationship.Book2User;
import com.example.MyBookShopApp.dto.user.UserContact;
import com.example.MyBookShopApp.services.relationship.Book2UserService;
import com.example.MyBookShopApp.services.user.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

//the controller responsible for the operation of the main page
@Controller
public class MainPageController {

    private UserContactService service;

    @Autowired
    public MainPageController(UserContactService service) {
        this.service = service;
    }

//    private final BookService bookService;
//
//    public MainPageController(BookService bookService) {
//        this.bookService = bookService;
//    }

    //return Model with recommended Books
//    @ModelAttribute("recommendedBooks")
//    public List<Book> recommendedBooks() {
//        return bookService.getBookData();
//    }

    //return main page
    @GetMapping("/")
    public String mainPage() {
        UserContact userContact = service.getUserContactById(1);
        Logger.getAnonymousLogger().info(userContact.toString());
        return "index";
    }
}
