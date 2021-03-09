package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.BalanceTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceTransactionRepository extends JpaRepository<BalanceTransaction, Integer> {
}
