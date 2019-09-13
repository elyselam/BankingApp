package com.company.app.services;

import com.company.app.models.Account;

public class BalanceUpdateService {

    public double deposit(double balance, double amount) {
        if (balance < 0) {
            System.out.println("Transaction failed, you have no money!");
        } else {
            balance = balance + amount;
        }
        return balance;
    }

    public double withdraw(double balance, double amount) {
        if (balance < 0) {
            System.out.println("Transaction failed, you have no money!");
        } else {
            balance = balance - amount;
        }
        return balance;
    }


    //check balances
    public double checkBalance(double balance, String id) {
        //Account account = new Account();
        return 0;//account.getBalance();
    }








}
