package com.techelevator;

public class CheckingAccount extends BankAccount{

public CheckingAccount(String accountHolderName, String accountNumber){
    super(accountHolderName, accountNumber);

}
public CheckingAccount(String accountHolderName, String accountNumber, int balance){
    super(accountHolderName, accountNumber, balance);
}

public int overDraftFee = 10;
public int minBalance = -100;

@Override
public int withdraw(int amountToWithdraw){
    int newBalance = getBalance() - amountToWithdraw;
    if (newBalance < 0 && newBalance > minBalance){
        super.withdraw(amountToWithdraw + overDraftFee);
        super.getBalance();
    } else if ( newBalance < minBalance){
        super.getBalance();
    }
    if (newBalance > 0){
        super.withdraw(amountToWithdraw);
        return super.getBalance();
    }
    if (newBalance == 0){
        super.withdraw(amountToWithdraw);
    }

    //if balance after withdraw is below 0 and above -100, withdraw amount and subtract 10
    //if balance after withdraw is above 0, run withdraw and return balance
    // if the balance after withdraw is lower then -100 do not allow and return balance

    return getBalance();

}
}
