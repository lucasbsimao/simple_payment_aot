package com.simple_payment_aot.transactions.domain.services;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
import com.simple_payment_aot.transactions.common.AccountNotFoundException;
import com.simple_payment_aot.transactions.domain.entities.OperationType;
import com.simple_payment_aot.transactions.domain.entities.Transaction;
import com.simple_payment_aot.transactions.domain.repositories.TransactionRepository;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionRequestDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGivenValidCreateTransactionDtoWithOperationType1_WhenCreate_ThenReturnStatusCreated()
            throws AccountNotFoundException {
        CreateTransactionRequestDto createTransactionRequestDto = new CreateTransactionRequestDto();
        createTransactionRequestDto.setAccountId(1);
        createTransactionRequestDto.setAmount("10.00");
        createTransactionRequestDto.setOperationType(1);

        RetrieveAccountDto retrieve = new RetrieveAccountDto(createTransactionRequestDto.getAccountId().toString(),
                "123456789");
        Mockito.when(this.accountService.get(Mockito.any(Integer.class))).thenReturn(retrieve);

        Transaction returnTransaction = new Transaction(createTransactionRequestDto.getAccountId(),
                OperationType.fromValue(createTransactionRequestDto.getOperationType()),
                -Integer.parseInt(createTransactionRequestDto.getFilteredAmount()));
        Mockito.when(this.transactionRepository.save(Mockito.any(Transaction.class))).thenReturn(returnTransaction);

        this.transactionService.create(createTransactionRequestDto);

        ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);
        Mockito.verify(this.transactionRepository).save(transactionCaptor.capture());

        Transaction transaction = transactionCaptor.getValue();
        assertThat(transaction.getAmount()).isEqualTo(-1000);
        assertThat(transaction.getAccountId()).isEqualTo(createTransactionRequestDto.getAccountId());
        assertThat(transaction.getOperationTypeId()).isEqualTo(createTransactionRequestDto.getOperationType());
    }

    @Test
    public void testGivenValidCreateTransactionDtoWithOperationType4_WhenCreate_ThenReturnStatusCreated()
            throws AccountNotFoundException {
        CreateTransactionRequestDto createTransactionRequestDto = new CreateTransactionRequestDto();
        createTransactionRequestDto.setAccountId(1);
        createTransactionRequestDto.setAmount("10.00");
        createTransactionRequestDto.setOperationType(4);

        RetrieveAccountDto retrieve = new RetrieveAccountDto(createTransactionRequestDto.getAccountId().toString(),
                "123456789");
        Mockito.when(this.accountService.get(Mockito.any(Integer.class))).thenReturn(retrieve);

        Transaction returnTransaction = new Transaction(createTransactionRequestDto.getAccountId(),
                OperationType.fromValue(createTransactionRequestDto.getOperationType()),
                -Integer.parseInt(createTransactionRequestDto.getFilteredAmount()));
        Mockito.when(this.transactionRepository.save(Mockito.any(Transaction.class))).thenReturn(returnTransaction);

        this.transactionService.create(createTransactionRequestDto);

        ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);
        Mockito.verify(this.transactionRepository).save(transactionCaptor.capture());

        Transaction transaction = transactionCaptor.getValue();
        assertThat(transaction.getAmount()).isEqualTo(1000);
        assertThat(transaction.getAccountId()).isEqualTo(createTransactionRequestDto.getAccountId());
        assertThat(transaction.getOperationTypeId()).isEqualTo(createTransactionRequestDto.getOperationType());
    }

    @Test
    public void testGivenCreateTransactionDtoWithNonExistentAccountId_WhenCreate_ThenThrowAccountNotFoundException(){
        CreateTransactionRequestDto createTransactionRequestDto = new CreateTransactionRequestDto();
        createTransactionRequestDto.setAccountId(1);
        createTransactionRequestDto.setAmount("10.00");
        createTransactionRequestDto.setOperationType(1);

        Mockito.when(this.accountService.get(Mockito.any(Integer.class))).thenReturn(null);

        assertThatThrownBy(() -> {this.transactionService.create(createTransactionRequestDto);})
                .isInstanceOf(AccountNotFoundException.class);
    }
}
