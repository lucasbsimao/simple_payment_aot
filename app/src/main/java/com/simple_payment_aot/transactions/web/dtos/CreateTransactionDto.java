package com.simple_payment_aot.transactions.web.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simple_payment_aot.transactions.domain.entities.OperationType;
import jakarta.validation.constraints.Pattern;

public class CreateTransactionDto {

    //TODO: Verificar mensagens de retorno
    @Pattern(regexp = "^[0-4]$", message = "Tipo de operação deve ser de 1 a 4")
    @JsonProperty("operation_type_id")
    private OperationType operationType;
    @JsonProperty("account_id")
    private Integer accountId;
    @Pattern(regexp = "^[0-9]+\\.[0-9]{2}$", message = "Deve respeitar o padrão com duas casas decimais com separação por ponto")
    private String amount;

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = OperationType.fromValue(operationType);
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
        this.amount = amount;
    }
}
