package com.company.app.models;

import java.security.SecureRandom;

public class Account {
    private int id;
    private double balance;


    public Account(int id, double balance) {
        //balance starts at 0
        this.balance = balance;

        //generate random numbers for customer id in range 10,000
        SecureRandom idGenerator = new SecureRandom();
        this.id = idGenerator.nextInt(10000);

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
