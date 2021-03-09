package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//the interface that is responsible for all the operations with the authors
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
