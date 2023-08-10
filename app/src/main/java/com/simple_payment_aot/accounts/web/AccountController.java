package com.simple_payment_aot.accounts.web;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountDto;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
import com.simple_payment_aot.accounts.web.handlers.AccountsExceptionHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateAccountDto createAccountDto) {

        this.accountService.create(createAccountDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/accounts/:id")
    public ResponseEntity<RetrieveAccountDto> get(@RequestParam("id") String accountId) {

        //TODO: Corrigir body
        if(this.accountService.get(accountId) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);

        return new ResponseEntity(this.accountService.get(accountId), HttpStatus.OK);
    }
}
