import com.company.app.models.Account;

import java.util.HashMap;
import java.util.Map;

//package com.company.app.services;
//
//import com.company.app.models.Account;
//
//public class BalanceUpdateService {
//
//    public double deposit(Account acct, double amount) {
//        acct.setBalance(acct.getBalance() + amount);
//        return acct.getBalance();
//    }
//
//    public double withdrawal(Account acct, double balance, double amount) {
//        double bal = acct.getBalance();
//        if (bal < 0) {
//            System.out.println("Transaction failed, you have no money!");
//        } else {
//            acct.setBalance(bal - amount);
//        }
//        return bal;
//    }
//    public double viewBalance(Account acct) {
//        return acct.getBalance();
//    }
//
//
//}
public class UserServices {
    private static UserServices instance = null;

    private Map<String, Account> map = new HashMap<>();

    private UserServices() {
    }

    public static UserServices getInstance() {
        if (instance == null) {
            instance = new com.company.app.services.AccountServices();
        }
        return instance;
    }

    //will use to return balance
    //this.map.get(double balance).getBalance();
    public Map<Integer, String> getMap() {
        return map;
    }

    //will use to pull file to service
    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void insertString(String string) {
        this.map.put(1, string);
    }

    public double authenticate() {
    }
}