package com.company.app.models;

import java.io.Serializable;
import java.security.SecureRandom;

//Serialize Account for createAccountDao
public class Account implements Serializable {
    private final int id;
    private double balance = 0;

    public Account() {
        //generate random numbers for customer id in range 10,000
        this.id = (new SecureRandom()).nextInt(10000);

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
