package com.simple_payment_aot.accounts.web;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountRequestDto;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountResponseDto;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
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
    public ResponseEntity<CreateAccountResponseDto> create(@Valid @RequestBody CreateAccountRequestDto createAccountRequestDto) {

        CreateAccountResponseDto createAccountResponseDto = this.accountService.create(createAccountRequestDto);

        return new ResponseEntity<>(createAccountResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<RetrieveAccountDto> get(@PathVariable  Integer accountId) {
        RetrieveAccountDto retrieveAccountDto = this.accountService.get(accountId);
        if(retrieveAccountDto == null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);

        return new ResponseEntity<>(retrieveAccountDto, HttpStatus.OK);
    }
}
