package com.simple_payment_aot.accounts.web;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountDto;
import com.simple_payment_aot.accounts.web.handlers.AccountsExceptionHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateAccountDto createAccountDto) {

        this.accountService.create(createAccountDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
