package org.bova.interview.sigma;

import java.math.BigDecimal;

public class MoneyTransfer {
    void transfer(Account from, Account to, BigDecimal amount) {
        from.substract(amount);
        to.add(amount);
    }
}
