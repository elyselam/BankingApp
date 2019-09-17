package com.company.app.services;

import com.company.app.models.Account;

public class BalanceUpdateService {

    public double deposit(Account acct, double amount) {
        acct.setBalance(acct.getBalance() + amount);
        return acct.getBalance();
    }



    public double withdrawal(Account acct, double balance, double amount) {
        double bal = acct.getBalance();
        if (bal < 0) {
            System.out.println("Transaction failed, you have no money!");
        } else {
            acct.setBalance(bal - amount);
        }
        return bal;
    }


    public double viewBalance(Account acct) {
        return acct.getBalance();
    }


}
