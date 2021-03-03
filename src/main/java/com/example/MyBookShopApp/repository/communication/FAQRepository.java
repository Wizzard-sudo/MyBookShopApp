package com.example.MyBookShopApp.repository.communication;

import com.example.MyBookShopApp.dto.communication.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
}
