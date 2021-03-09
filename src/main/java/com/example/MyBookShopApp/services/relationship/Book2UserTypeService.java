package com.example.MyBookShopApp.services.relationship;

import com.example.MyBookShopApp.dto.relationship.Book2UserType;
import com.example.MyBookShopApp.repository.relationship.Book2UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Book2UserTypeService {

    private final Book2UserTypeRepository book2UserTypeRepository;

    @Autowired
    public Book2UserTypeService(Book2UserTypeRepository book2UserTypeRepository) {
        this.book2UserTypeRepository = book2UserTypeRepository;
    }

    public Book2UserType getBook2UserType(Integer id){
        return book2UserTypeRepository.findById(id).get();
    }
}
