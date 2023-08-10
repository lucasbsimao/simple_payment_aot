package com.simple_payment_aot.accounts.domain.services;

import com.simple_payment_aot.accounts.domain.common.ConflictException;
import com.simple_payment_aot.accounts.domain.entities.Account;
import com.simple_payment_aot.accounts.domain.repositories.AccountRepository;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountDto;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void create(CreateAccountDto createAccountDto) {
        Optional<Account> optionalAccount = this.accountRepository.findByDocumentNumber(createAccountDto.getDocumentNumber());

        Account account = new Account(createAccountDto.getDocumentNumber());
        this.accountRepository.save(account);
    }

    public RetrieveAccountDto get(String accountId) {
        Optional<Account> optionalAccount = this.accountRepository.findByAccountId(Integer.parseInt(accountId));

        if(optionalAccount.isPresent()) return new RetrieveAccountDto(optionalAccount.get().getDocumentNumber(),
                optionalAccount.get().getAccountId().toString());

        return null;
    }
}
