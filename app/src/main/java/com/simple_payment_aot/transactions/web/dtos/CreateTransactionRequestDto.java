package com.simple_payment_aot.transactions.web.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public class CreateTransactionRequestDto {

    @Schema(example = "1")
    @Min(value = 1, message = "Tipo de operação deve ser de 1 a 4")
    @Max(value = 4, message = "Tipo de operação deve ser de 1 a 4")
    @NotNull(message = "Campo operationType deve ser informado")
    @JsonProperty("operation_type_id")
    private Integer operationType;

    @NotNull(message = "Campo accountId deve ser informado")
    @JsonProperty("account_id")
    private Integer accountId;
    
    @Schema(example = "10.32")
    @NotNull(message = "Campo amount deve ser informado")
    @Pattern(regexp = "^[0-9]+\\.[0-9]{2}$", message = "Deve respeitar o padrão com duas casas decimais com separação por ponto")
    private String amount;

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

    @JsonIgnore
    public String getFilteredAmount() {
        return amount.replace(".", "");
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
