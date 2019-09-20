package com.company.app.dao;

import com.company.app.models.Account;
import com.company.app.models.Users;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Collection;
import java.util.HashMap;


public class AccountDao implements DaoInterface {

    HashMap<Integer, Account> map = new HashMap<>();

    public Account getAccount(int id) {
        return map.get(id);
    }

    @Override
    public void write() {

    }

    @Override
    public void read() {

    }

    public double viewBalance(Account acct) {
        return acct.getBalance();
    }

    public int createNewAccount(String email) {
        Account account = new Account();
        map.put(account.getId(), account);
        return account.getId();
    }
}

