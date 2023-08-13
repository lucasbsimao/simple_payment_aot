package com.simple_payment_aot.transactions.domain.services;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.transactions.common.AccountNotFoundException;
import com.simple_payment_aot.transactions.domain.entities.OperationType;
import com.simple_payment_aot.transactions.domain.entities.Transaction;
import com.simple_payment_aot.transactions.domain.repositories.TransactionRepository;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;

    public void create(CreateTransactionDto createTransactionDto) throws AccountNotFoundException {
        if(this.accountService.get(createTransactionDto.getAccountId()) == null)
            throw new AccountNotFoundException("Não foi possível criar transação. AccountId informada ("
                    .concat(createTransactionDto.getAccountId().toString())
                    .concat(") não encontrada"));

        Transaction account = new Transaction(createTransactionDto.getAccountId(),
                OperationType.fromValue(createTransactionDto.getOperationType()),
                Long.parseLong(createTransactionDto.getAmount()));
        this.transactionRepository.save(account);
    }
}
