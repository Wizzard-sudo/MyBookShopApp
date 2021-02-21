package com.example.MyBookShopApp.controllers.safety;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//the controller responsible for accessing the location
@Controller
public class LoginController {

    //logging in to the app, return login page
    @GetMapping("/signin")
    public String signIn(){
        return "signin";
    }

    //registering in the app, return signup page
    @GetMapping("/signup")
    public String signUp(){ return "signup";}
}
