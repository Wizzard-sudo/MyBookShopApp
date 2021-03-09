package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.BalanceTransaction;
import com.example.MyBookShopApp.repository.BalanceTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceTransactionService {

    private final BalanceTransactionRepository balanceTransactionRepository;

    @Autowired
    public BalanceTransactionService(BalanceTransactionRepository balanceTransactionRepository) {
        this.balanceTransactionRepository = balanceTransactionRepository;
    }

    public BalanceTransaction getBalanceTransactionById(Integer id){
        return balanceTransactionRepository.findById(id).get();
    }
}
