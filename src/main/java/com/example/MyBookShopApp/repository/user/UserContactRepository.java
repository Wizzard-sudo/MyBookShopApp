package com.example.MyBookShopApp.repository.user;

import com.example.MyBookShopApp.dto.user.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact, Integer> {
}
