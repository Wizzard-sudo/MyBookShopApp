package com.example.MyBookShopApp.repository.communication;

import com.example.MyBookShopApp.dto.communication.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
