package com.simple_payment_aot.transactions.domain.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransactionTest {

    @Test
    public void testWhenCreatedTransactionWithCompraAVista_thenTransactionHasAmountNegative() {
        Transaction transaction = new Transaction(1, OperationType.COMPRA_A_VISTA, 1000);

        assertThat(transaction.getAmount()).isEqualTo(-1000);
    }

    @Test
    public void testWhenCreatedTransactionWithPagamento_thenTransactionHasAmountPositive() {
        Transaction transaction = new Transaction(1, OperationType.PAGAMENTO, 1000);

        assertThat(transaction.getAmount()).isEqualTo(1000);
    }

}
