package com.simple_payment_aot.transactions.domain.common;

//TODO: Deve ser global?
public class ConflictException extends RuntimeException {
    public ConflictException(String statusText) {
        super(statusText);
    }
}
