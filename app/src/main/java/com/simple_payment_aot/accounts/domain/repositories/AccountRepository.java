package com.simple_payment_aot.accounts.domain.repositories;

import com.simple_payment_aot.accounts.domain.entities.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    public Optional<Account> findByDocumentNumber(String docNum);
    public Optional<Account> findByAccountId(Integer id);
}
