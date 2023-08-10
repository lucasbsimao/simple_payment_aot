package com.simple_payment_aot.transactions.domain.repositories;

import com.simple_payment_aot.transactions.domain.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    public Optional<Transaction> findByTransactionId(Integer id);
}
