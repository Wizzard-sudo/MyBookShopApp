package com.example.MyBookShopApp.services.book;

import com.example.MyBookShopApp.dto.book.BookFile;
import com.example.MyBookShopApp.repository.book.BookFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookFileService {

    private BookFileRepository bookFileRepository;

    @Autowired
    public BookFileService(BookFileRepository bookFileRepository) {
        this.bookFileRepository = bookFileRepository;
    }

    public BookFile getBookFileById(Integer id){
        return bookFileRepository.findById(id).get();
    }

    public BookFile getBookFileByHash(String hash){ return bookFileRepository.findBookFileByHash(hash);}
}
