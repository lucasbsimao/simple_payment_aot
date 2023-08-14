package com.simple_payment_aot.accounts.web;

import com.simple_payment_aot.accounts.domain.services.AccountService;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountRequestDto;
import com.simple_payment_aot.accounts.web.dtos.CreateAccountResponseDto;
import com.simple_payment_aot.accounts.web.dtos.RetrieveAccountDto;
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
import org.springframework.web.bind.annotation.*;

@Tag(name = "Account API")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Retrieve an Account by Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = RetrieveAccountDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<RetrieveAccountDto> get(@PathVariable  Integer accountId) {
        RetrieveAccountDto retrieveAccountDto = this.accountService.get(accountId);
        if(retrieveAccountDto == null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);

        return new ResponseEntity<>(retrieveAccountDto, HttpStatus.OK);
    }

    @Operation(summary = "Create an Account")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CreateAccountResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/accounts")
    public ResponseEntity<CreateAccountResponseDto> create(@Valid @RequestBody CreateAccountRequestDto createAccountRequestDto) {

        CreateAccountResponseDto createAccountResponseDto = this.accountService.create(createAccountRequestDto);

        return new ResponseEntity<>(createAccountResponseDto, HttpStatus.CREATED);
    }
}
