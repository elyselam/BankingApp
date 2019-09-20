package com.company.app.services;

import com.company.app.dao.AccountRepository;
import com.company.app.models.Account;
import com.company.platform.Application;

public class AccountServices {

    AccountRepository accountDao;

    public AccountServices(){}

    public void setAccountJDBCDao(AccountRepository accountDao) {
        this.accountDao = accountDao;
    }


    public double deposit(Account acct, double amount) {
        //calculate the new balance
        acct.setBalance(acct.getBalance() + amount);
        //persist the new balance
        //set the new balance on the account
        accountDao.save(acct);
        //return new balance
        return acct.getBalance();
    }

    public double withdrawal(Account acct, double amount) {
        //don't allow if withdrawal leaves balance below 0
        //set new balance on account
        if (acct.getBalance() - amount < 0) {
            System.out.println("Transaction failed");
        } else {
            acct.setBalance(acct.getBalance() - amount);
            accountDao.save(acct);
        }
        return acct.getBalance();
    }
}

