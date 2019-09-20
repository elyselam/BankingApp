package com.company.app.services;

import com.company.app.dao.AccountDao;
import com.company.app.models.Account;
import com.company.platform.Application;

public class AccountServices {

    AccountDao accountDao;

    public AccountServices(Application app) {
        accountDao = app.getAccountDao();
    }


    public double deposit(Account acct, double amount) {
        acct.setBalance(acct.getBalance() + amount);
        return acct.getBalance();
    }

    public double withdrawal(Account acct, double amount) {
        if (acct.getBalance() < 0) {
            System.out.println("Transaction failed, you have no money!");
        } else {
            acct.setBalance(acct.getBalance() - amount);
        }
        return acct.getBalance();
    }

    public double viewBalance(Account acct) {
        return acct.getBalance();
    }
}

