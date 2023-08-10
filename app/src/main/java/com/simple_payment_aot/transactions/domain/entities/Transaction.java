package com.simple_payment_aot.transactions.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Transaction {

    public Transaction(Integer accountId, OperationType operationTypeId, Double amount) {
        this.accountId = accountId;
        this.operationTypeId = operationTypeId.value;
        this.computeAmount(operationTypeId, amount);
    }

    public Transaction(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Column(name = "operation_type_id")
    private String operationTypeId;
    @Column(name = "account_id")
    private Integer accountId;
    private Double amount;

    public void computeAmount(OperationType type, Double amount) {
        this.amount = switch (type) {
            case COMPRA_A_VISTA, COMPRA_PARCELADA, SAQUE -> -amount;
            case PAGAMENTO -> amount;
        };
    }

}
