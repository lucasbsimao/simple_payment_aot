package com.simple_payment_aot.accounts.domain.services;

import com.simple_payment_aot.accounts.domain.common.ConflictException;
import com.simple_payment_aot.accounts.domain.entities.Account;
import com.simple_payment_aot.accounts.domain.repositories.AccountRepository;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountDto;
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

        if(optionalAccount.isPresent()) throw new ConflictException("Uma conta com documento "
                .concat(createAccountDto.getDocumentNumber())
                .concat(" já foi criada"));

        Account account = new Account(createAccountDto.getDocumentNumber());
        this.accountRepository.save(account);
    }
}
