package com.simple_payment_aot.accounts.web.dtos;

public class CreateAccountResponseDto {

    public CreateAccountResponseDto(String accountId, String documentNumber){
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }

    private String accountId;
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
