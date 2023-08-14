package com.simple_payment_aot.accounts.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

public class RetrieveAccountDto {

    public RetrieveAccountDto(String accountId, String documentNumber) {
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


    public String getAccountId() {
        return accountId;
    }

}
