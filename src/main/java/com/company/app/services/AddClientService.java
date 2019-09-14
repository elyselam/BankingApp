package com.company.app.services;

//employee creates account
//make instance of Account class

import com.company.app.models.Account;
import com.company.app.models.Customer;

public class AddClientService {

    public void createCustomer(String email, String password){
        Customer newCustomer = new Customer(firstName, lastName, email, password);
    }

    public void createAccount() {
        Account newClient = new Account(id, balance);

    }
}
