package com.example.MyBookShopApp.repository.relationship;

import com.example.MyBookShopApp.dto.relationship.Book2User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2UserRepository extends JpaRepository<Book2User, Integer> {
}
