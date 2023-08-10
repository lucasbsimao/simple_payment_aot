package com.simple_payment_aot.accounts.web.handlers;

import com.simple_payment_aot.accounts.domain.common.ConflictException;
import com.simple_payment_aot.accounts.web.AccountController;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountConflictDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {AccountController.class})
public class AccountsExceptionHandler {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<CreateAccountConflictDto> handleNotFoundException(ConflictException ex) {
        CreateAccountConflictDto conflictDto = new CreateAccountConflictDto(ex.getMessage());

        return new ResponseEntity<CreateAccountConflictDto>(conflictDto, HttpStatus.CONFLICT);
    }
}
