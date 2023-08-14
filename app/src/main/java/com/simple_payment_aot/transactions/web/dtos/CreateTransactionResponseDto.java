package com.simple_payment_aot.transactions.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateTransactionResponseDto {

    private Integer transactionId;
    private Integer operationType;
    private Integer accountId;
    private String amount;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        if(amount.contains(".")){
            this.amount = amount;
        } else {
            int dotPos = amount.length() - 2;
            this.amount = amount.substring(0, dotPos) + "." + amount.substring(dotPos);
        }
    }
}
