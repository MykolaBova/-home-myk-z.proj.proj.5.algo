package org.bova.interview.sigma;

import java.math.BigDecimal;

public class Account {
    BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    Account(BigDecimal balance) {
        this.balance = balance;
    }

    public void add(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void substract(BigDecimal amount) {
        this.balance = this.balance.add(amount.negate());
    }
}
