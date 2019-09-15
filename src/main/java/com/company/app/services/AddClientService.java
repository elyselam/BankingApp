package com.company.app.services;



import java.io.File;
import java.io.FileOutputStream;

//employee creates account
//make instance of Account class

import com.company.app.models.Account;


import java.io.IOException;
import java.util.HashMap;

public class AddClientService {

    //i want {email, {id, balance}}
    HashMap<String, Account> clientList= new HashMap();

    public void createAccount(String  email) {
        Account newClient = new Account();
        //(email, Account{id, balance})
        clientList.put(email, newClient);
    }
    //output file
    public static final String file = "src/resources/data.txt";

}

