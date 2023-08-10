package com.simple_payment_aot.transactions.web;

import com.simple_payment_aot.transactions.domain.services.TransactionService;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateTransactionDto createTransactionDto) {

        this.transactionService.create(createTransactionDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
