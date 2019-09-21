package com.company.app.dao;

import com.company.app.models.Account;
import com.company.app.models.Users;


import java.util.Collection;
import java.util.HashMap;


public class AccountJDBCDao implements AccountRepository{
    //<id, {email, password, balance}
    HashMap<Integer, Account> map = new HashMap<>();

    public Account getAccount(int id) {
        return map.get(id);
    }

    //get balance by keying on id
    public double viewBalance(Account acct) {
        return acct.getBalance();
    }


    public int createNewAccount() {
        Account account = new Account();
        //id is integer
        map.put(account.getId(), account);
        //email, {id, balance}
        return account.getId();
    }




    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Collection<Account> findAll() {
        return null;
    }

    @Override
    public int save(Account obj) {
        return 0;
    }

    @Override
    public void delete(Account obj) {

    }
}

