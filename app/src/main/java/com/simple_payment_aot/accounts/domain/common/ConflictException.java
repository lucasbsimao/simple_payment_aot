package com.simple_payment_aot.accounts.domain.common;

public class ConflictException extends RuntimeException {
    public ConflictException(String statusText) {
        super(statusText);
    }
}
