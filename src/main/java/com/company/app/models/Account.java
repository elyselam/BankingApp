package com.company.app.models;

import java.security.SecureRandom;

public class Account {
    private final int id;
    private double balance = 0;

    public Account() {
        //generate random numbers for customer id in range 10,000
        SecureRandom idGenerator = new SecureRandom();
        this.id = idGenerator.nextInt(10000);
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
