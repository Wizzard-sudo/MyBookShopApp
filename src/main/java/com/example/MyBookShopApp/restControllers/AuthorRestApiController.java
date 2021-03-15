package com.example.MyBookShopApp.restControllers;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.services.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(description = "authors data")
public class AuthorRestApiController {

    private final AuthorService authorService;

    @Autowired
    public AuthorRestApiController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ApiOperation("method to get map of authors")
    @GetMapping("/authors")
    @ResponseBody
    public Map<String, List<Author>> authorsData(){
        return authorService.getAuthorsMap();
    }
}
