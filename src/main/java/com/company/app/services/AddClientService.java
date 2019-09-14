package com.company.app.screens.employee;

//employee creates account
//make instance of Account class

import com.company.app.models.Account;
import com.company.app.models.Customer;

public class AddClient {

    public void createCustomer(String firstName, String lastName, String email, String password){
        Customer newCustomer = new Customer(firstName, lastName, email, password);
    }

    public void createAccount(int id, double balance) {
        Account newClient = new Account(id, balance);

    }
}
