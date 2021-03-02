package com.example.MyBookShopApp.repository.relationship;

import com.example.MyBookShopApp.dto.relationship.Book2UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2UserTypeRepository extends JpaRepository<Book2UserType, Integer> {
}
