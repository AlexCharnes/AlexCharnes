package com.techelevator.exceptions.accounts;

public class BelowMiniumBalanceException extends Exception {

    private int feeAmount;

    public BelowMiniumBalanceException(int feeAmount) {
        super("Account below minimum balance.  $" + feeAmount + " Fee accessed.");
        this.feeAmount = feeAmount;
    }

    public int getFeeAmount() {
        return this.feeAmount;
    }
}
