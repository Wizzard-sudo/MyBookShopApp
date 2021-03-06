package com.example.MyBookShopApp.services.relationship;

import com.example.MyBookShopApp.dto.relationship.Book2User;
import com.example.MyBookShopApp.repository.relationship.Book2UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Book2UserService {

    private final Book2UserRepository book2UserRepository;

    @Autowired
    public Book2UserService(Book2UserRepository book2UserRepository) {
        this.book2UserRepository = book2UserRepository;
    }

    public Book2User getBook2UserById(Integer id){
        return book2UserRepository.findById(id).get();
    }
}
