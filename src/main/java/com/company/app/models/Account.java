package com.company.app.models;

import java.io.Serializable;
import java.security.SecureRandom;

//Serialize Account for createAccountDao
public class Account implements Serializable {
    private final int id;
    private double balance = 0;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    
    public int getId() {
        return id;
    }


    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
