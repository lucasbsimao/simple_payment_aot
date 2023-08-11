package com.simple_payment_aot.transactions.web;

import com.simple_payment_aot.transactions.common.AccountNotFoundException;
import com.simple_payment_aot.transactions.domain.services.TransactionService;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateTransactionDto createTransactionDto) {

        try {
            this.transactionService.create(createTransactionDto);
        } catch (AccountNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
