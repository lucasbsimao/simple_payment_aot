package com.simple_payment_aot.transactions.web;

import com.simple_payment_aot.transactions.common.AccountNotFoundException;
import com.simple_payment_aot.transactions.domain.services.TransactionService;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionRequestDto;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionResponseDto;
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
    public ResponseEntity<CreateTransactionResponseDto> create(@Valid @RequestBody CreateTransactionRequestDto createTransactionRequestDto) {

        CreateTransactionResponseDto createAccountResponseDto;
        try {
            createAccountResponseDto = this.transactionService.create(createTransactionRequestDto);
        } catch (AccountNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
        return new ResponseEntity<>(createAccountResponseDto, HttpStatus.CREATED);
    }
}
