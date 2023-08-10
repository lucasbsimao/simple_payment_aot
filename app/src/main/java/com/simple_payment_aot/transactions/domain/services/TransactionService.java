package com.simple_payment_aot.transactions.domain.services;

import com.simple_payment_aot.transactions.domain.entities.Transaction;
import com.simple_payment_aot.transactions.domain.repositories.TransactionRepository;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void create(CreateTransactionDto createTransactionDto) {
        Transaction account = new Transaction(createTransactionDto.getAccountId(),
                createTransactionDto.getOperationType(),
                Double.parseDouble(createTransactionDto.getAmount()));
        this.transactionRepository.save(account);
    }
}
