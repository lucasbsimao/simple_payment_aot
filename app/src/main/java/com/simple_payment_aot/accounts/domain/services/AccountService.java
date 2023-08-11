package com.simple_payment_aot.accounts.domain.services;

import com.simple_payment_aot.accounts.domain.entities.Account;
import com.simple_payment_aot.accounts.domain.repositories.AccountRepository;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountRequestDto;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountResponseDto;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public CreateAccountResponseDto create(CreateAccountRequestDto createAccountRequestDto) {
        Account account = new Account(createAccountRequestDto.getDocumentNumber());
        account = this.accountRepository.save(account);

        return new CreateAccountResponseDto(account.getAccountId().toString(),
                account.getDocumentNumber());
    }

    public RetrieveAccountDto get(Integer accountId) {
        Optional<Account> optionalAccount = this.accountRepository.findByAccountId(accountId);

        if(optionalAccount.isPresent()) return new RetrieveAccountDto(optionalAccount.get().getAccountId().toString(),
                optionalAccount.get().getDocumentNumber());

        return null;
    }
}
