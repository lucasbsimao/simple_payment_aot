package com.simple_payment_aot.accounts.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class CreateAccountResponseDto {

    public CreateAccountResponseDto(String accountId, String documentNumber){
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }

    @Schema(example = "10")
    @JsonProperty("account_id")
    private String accountId;
    
    @Schema(example = "123456789")
    @JsonProperty("document_number")
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
