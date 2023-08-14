package com.simple_payment_aot.transactions.domain.services;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.transactions.common.AccountNotFoundException;
import com.simple_payment_aot.transactions.domain.entities.OperationType;
import com.simple_payment_aot.transactions.domain.entities.Transaction;
import com.simple_payment_aot.transactions.domain.repositories.TransactionRepository;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionRequestDto;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;

    public CreateTransactionResponseDto create(CreateTransactionRequestDto createTransactionRequestDto) throws AccountNotFoundException {
        if(this.accountService.get(createTransactionRequestDto.getAccountId()) == null)
            throw new AccountNotFoundException("Não foi possível criar transação. AccountId informada ("
                    .concat(createTransactionRequestDto.getAccountId().toString())
                    .concat(") não encontrada"));

        Transaction account = new Transaction(createTransactionRequestDto.getAccountId(),
                OperationType.fromValue(createTransactionRequestDto.getOperationType()),
                Long.parseLong(createTransactionRequestDto.getFilteredAmount()));

        account = this.transactionRepository.save(account);

        CreateTransactionResponseDto createTransactionResponseDto = new CreateTransactionResponseDto();
        createTransactionResponseDto.setTransactionId(account.getTransactionId());
        createTransactionResponseDto.setAmount(String.valueOf(account.getAmount()));
        createTransactionResponseDto.setAccountId(account.getAccountId());
        createTransactionResponseDto.setOperationType(account.getOperationTypeId());

        return createTransactionResponseDto;
    }
}
