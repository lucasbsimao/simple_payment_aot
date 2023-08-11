package com.simple_payment_aot.accounts.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Account(){}

    @Id
    @GeneratedValue
    @JsonProperty("account_id")
    private Integer accountId;

    @JsonProperty("document_number")
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
