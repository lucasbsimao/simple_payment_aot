package com.simple_payment_aot.accounts.domain.services;

import com.simple_payment_aot.accounts.domain.entities.Account;
import com.simple_payment_aot.accounts.domain.repositories.AccountRepository;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountRequestDto;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountResponseDto;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void testGivenValidatedCreateAccountDto_WhenCreate_ThenReturnResponseWithId(){
        CreateAccountRequestDto createAccountRequestDto =
                new CreateAccountRequestDto("123456789");

        Account account = new Account();
        account.setAccountId(1);
        account.setDocumentNumber(createAccountRequestDto.getDocumentNumber());

        Mockito.when(this.accountRepository.save(Mockito.any(Account.class))).thenReturn(account);

        CreateAccountResponseDto response = this.accountService.create(createAccountRequestDto);

        assertThat(response.getDocumentNumber()).isEqualTo(account.getDocumentNumber());
        assertThat(response.getAccountId()).isEqualTo(account.getAccountId().toString());
    }

    @Test
    public void testGivenResource_WhenGet_ThenReturnFullResponse(){
        Account account = new Account();
        account.setAccountId(1);
        account.setDocumentNumber("123456789");

        Mockito.when(this.accountRepository.findByAccountId(Mockito.any(Integer.class))).thenReturn(Optional.of(account));

        RetrieveAccountDto response = this.accountService.get(1);

        assertThat(response.getDocumentNumber()).isEqualTo(account.getDocumentNumber());
        assertThat(response.getAccountId()).isEqualTo(account.getAccountId().toString());
    }

    @Test
    public void testGivenNonExistentResource_WhenGet_ThenReturnFullResponse(){
        Mockito.when(this.accountRepository.findByAccountId(Mockito.any(Integer.class))).thenReturn(Optional.empty());

        RetrieveAccountDto response = this.accountService.get(1);

        assertThat(response).isNull();
    }
}
