package com.simple_payment_aot.accounts.web.dtos;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CreateAccountConflictDto {

    public CreateAccountConflictDto(String message) {
        this.status = HttpStatus.CONFLICT.value();
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    private Integer status;
    private LocalDateTime timestamp;
    private String message;

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
