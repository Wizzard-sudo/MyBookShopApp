package com.example.MyBookShopApp.services.relationship;

import com.example.MyBookShopApp.dto.Author;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.relationship.Book2Author;
import com.example.MyBookShopApp.repository.relationship.Book2AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class Book2AuthorService {

    private final Book2AuthorRepository book2AuthorRepository;

    @Autowired
    public Book2AuthorService(Book2AuthorRepository book2AuthorRepository) {
        this.book2AuthorRepository = book2AuthorRepository;
    }

    public Book2Author getBook2Author(Integer id){return book2AuthorRepository.findById(id).get();}

    public Page<Book2Author> getBook2AuthorsByAuthor(Author author, Pageable pageable){
        return book2AuthorRepository.findBook2AuthorsByAuthor(author, pageable);
    }
}
