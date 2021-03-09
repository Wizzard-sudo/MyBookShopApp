package com.example.MyBookShopApp.services.communication;

import com.example.MyBookShopApp.dto.communication.Message;
import com.example.MyBookShopApp.repository.communication.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message getMessageById(Integer id){
        return messageRepository.findById(id).get();
    }
}
