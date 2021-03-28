package org.bova.interview.sigma;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MoneyTransferTest {

    @Test
    void testTransfer_maunFlow() {
        MoneyTransfer moneyTransfer = new MoneyTransfer();
        Account from = new Account(new BigDecimal(100));
        Account to = new Account(new BigDecimal(10));

        moneyTransfer.transfer(from, to, new BigDecimal(10));

        assertEquals(from.getBalance(), new BigDecimal(90));
        assertEquals(to.getBalance(), new BigDecimal(20));
    }

}
