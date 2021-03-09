package com.example.MyBookShopApp.repository.communication;

import com.example.MyBookShopApp.dto.communication.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
