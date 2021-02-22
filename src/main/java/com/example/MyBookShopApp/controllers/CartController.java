package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//the controller responsible for working with saved books
@Controller
public class CartController {

    //return page with postponed books
    @GetMapping("/postponed")
    public String postponedPage() {
        return "postponed";
    }

    //return page with cart users
    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }
}
