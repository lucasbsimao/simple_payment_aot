package com.simple_payment_aot.transactions.web;

import com.simple_payment_aot.transactions.common.AccountNotFoundException;
import com.simple_payment_aot.transactions.domain.services.TransactionService;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionRequestDto;
import com.simple_payment_aot.transactions.web.dtos.CreateTransactionResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Tag(name = "Transaction API")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Create a Transaction")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateTransactionResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/transactions")
    public ResponseEntity<CreateTransactionResponseDto> create(@Valid @RequestBody CreateTransactionRequestDto createTransactionRequestDto) {

        CreateTransactionResponseDto createAccountResponseDto;
        try {
            createAccountResponseDto = this.transactionService.create(createTransactionRequestDto);
        } catch (AccountNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
        return new ResponseEntity<>(createAccountResponseDto, HttpStatus.CREATED);
    }
}
