package com.company.app.services;
//
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//
////employee creates account
////make instance of Account class
//
//import com.company.app.models.Account;
//
//
//import java.io.IOException;
//import java.util.HashMap;
//
//public class AddClientService {
//
//    //i want {email, {id, balance}}
//    HashMap<String, Account> clientList= new HashMap();
//
//    public void createAccount(String  email) {
//        Account newClient = new Account();
//        //(email, Account{id, balance})
//        clientList.put(email, newClient);
//    }
//    //output file
//    public static final String file = "src/resources/data.txt";
//
//}
//


import java.util.HashMap;
import java.util.Map;
public class AddClientService {
    private static AddClientService instance = null;

    private Map<Integer, String> map = new HashMap<Integer, String>();

    private AddClientService() {
    }

    public static AddClientService getInstance() {
        if(instance == null) {
            instance = new AddClientService();
        }
        return instance;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void insertString(String string) {
        this.map.put(1, string);
    }

}



