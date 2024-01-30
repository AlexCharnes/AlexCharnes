package com.techelevator;

public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);

    }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int newBalance = getBalance() - amountToWithdraw;
        if (newBalance >= 150){
            super.withdraw(amountToWithdraw);
            return getBalance();
        }
        if (newBalance < 150 && newBalance >= 2) {
            super.withdraw(amountToWithdraw + 2);
            return getBalance() ;
        }
        else if (newBalance <= 1) {
            return getBalance();
        }
        return getBalance();
    }
}
