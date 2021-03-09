package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.book.BookFileType;
import com.example.MyBookShopApp.repository.book.BookFileTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookFileTypeService {

    private final BookFileTypeRepository bookFileTypeRepository;

    @Autowired
    public BookFileTypeService(BookFileTypeRepository bookFileTypeRepository) {
        this.bookFileTypeRepository = bookFileTypeRepository;
    }

    public BookFileType getBookFileTypeById(Integer id){
        return bookFileTypeRepository.findById(id).get();
    }
}
