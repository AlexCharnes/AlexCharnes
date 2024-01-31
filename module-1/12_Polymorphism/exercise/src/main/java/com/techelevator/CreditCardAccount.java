package com.techelevator;

public class CreditCardAccount implements Accountable{

    public int getBalance(){
        return getBalance();
    };

    String accountHolderName;

    String cardNumber;

    int debt;

    int balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getDebt() {
        return debt;
    }


    public CreditCardAccount(String accountHolderName, String cardNumber){
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;

    }
    public int pay(int amountToPay){
return 2;
    }
}
