package com.company.app.dao;

import com.company.Main;
import com.company.app.models.Account;
import com.company.app.models.Users;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;


public class AccountJDBCDao implements AccountRepository{

    public Account getByEmail(String email) {
        String sql = "SELECT email, balance, id from account_table where email = ?";
        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet results = statement.executeQuery();
            Users u = null;
            while(results.next()){
                String email = results.getInt("balance");
                String _email = results.getString("email");
                u = new Users (id, email);
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Collection<Account> findAll() {
        return null;
    }


    public int save(Account obj) {
        return 0;
    }


    public void delete(Account obj) {

    }
}



//    //<id, {email, password, balance}
//    HashMap<Integer, Account> map = new HashMap<>();
//
//    public Account getAccount(int id) {
//        return map.get(id);
//    }
//
//    //get balance by keying on id
//    public double viewBalance(Account acct) {
//        return acct.getBalance();
//    }
//
//
//    public int createNewAccount() {
//        Account account = new Account();
//        //id is integer
//        map.put(account.getId(), account);
//        //email, {id, balance}
//        return account.getId();
//    }
//
//
