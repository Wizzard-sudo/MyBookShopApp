package com.example.MyBookShopApp.services.communication;

import com.example.MyBookShopApp.dto.communication.FAQ;
import com.example.MyBookShopApp.repository.communication.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FAQService {

    private FAQRepository faqRepository;

    @Autowired
    public FAQService(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public FAQ getFAQById(Integer id){
        return faqRepository.findById(id).get();
    }
}
