package com.company.app.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;

//employee creates account
//make instance of Account class

import com.company.app.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class AddClientService {

    //<email, {id, balance}
    HashMap<String, Account> clientList= new HashMap();

    public void createAccount(String  email) {
        Account newClient = new Account();
        clientList.put(email, newClient);
    }


    private void createAccount() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        AddClientService addAccount = new AddClientService();

        File file = new File("src/resources/data.json");
        if (!file.exists()) {
            file.createNewFile();

        } else {
            try {
                mapper.writeValue(new FileOutputStream("src/resources/data.json"), clientList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //LOG.info("account has been added");
        }
    }
}

