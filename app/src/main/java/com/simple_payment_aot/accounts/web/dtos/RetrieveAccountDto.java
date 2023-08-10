package com.simple_payment_aot.accounts.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

public class RetrieveAccountDto {

    public RetrieveAccountDto(String accountId, String documentNumber) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("document_number")
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }


    public String getAccountId() {
        return accountId;
    }

}
