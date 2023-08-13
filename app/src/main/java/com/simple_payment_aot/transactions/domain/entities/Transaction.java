package com.simple_payment_aot.transactions.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Transaction {

    public Transaction(Integer accountId, OperationType operationTypeId, long amount) {
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
    private Integer operationTypeId;
    @Column(name = "account_id")
    private Integer accountId;
    private long amount;

    private void computeAmount(OperationType type, long amount) {
        this.amount = switch (type) {
            case COMPRA_A_VISTA, COMPRA_PARCELADA, SAQUE -> -amount;
            case PAGAMENTO -> amount;
        };
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Integer getOperationTypeId() {
        return operationTypeId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public long getAmount() {
        return amount;
    }
}
