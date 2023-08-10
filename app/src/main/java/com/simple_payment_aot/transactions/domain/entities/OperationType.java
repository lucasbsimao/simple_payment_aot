package com.simple_payment_aot.transactions.domain.entities;

public enum OperationType {
    COMPRA_A_VISTA("1"),
    COMPRA_PARCELADA("2"),
    SAQUE("3"),
    PAGAMENTO("4");

    // TODO: VAI FICAR ASSIM MESMO?
    public static OperationType fromValue(String value) {
        for (OperationType type : OperationType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid OperationType value: " + value);
    }
    public final String value;

    private OperationType(String value) {
        this.value = value;
    }
}
