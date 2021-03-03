package com.example.MyBookShopApp.services.communication;

import com.example.MyBookShopApp.dto.communication.Document;
import com.example.MyBookShopApp.repository.communication.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document getDocumentById(Integer id){
        return documentRepository.findById(id).get();
    }
}
