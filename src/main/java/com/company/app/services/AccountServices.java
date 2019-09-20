package com.company.app.services;

import com.company.app.dao.AccountDao;
import com.company.app.dao.AccountRepository;
import com.company.app.models.Account;
import com.company.platform.Application;

public class AccountServices {

    AccountRepository accountDao;

    public AccountServices(){}

    public void setAccountDao(AccountRepository accountDao) {
        this.accountDao = accountDao;
    }


    public double deposit(Account acct, double amount) {
        //calculate the new balance
        //persist the new balance
        //set the new balance on the account
        //return
        acct.setBalance(acct.getBalance() + amount);
        accountDao.save(acct);
        return acct.getBalance();
    }

    public double withdrawal(Account acct, double amount) {
        if (acct.getBalance()-amount >= 0) {
            System.out.println("Transaction failed");
        } else {
            acct.setBalance(acct.getBalance() - amount);
        }
        return acct.getBalance();
    }

}

