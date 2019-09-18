package com.company.app.dao;

import com.company.app.models.Account;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class AccountDao implements DaoInterface{

    //output file
    public static final String filename = "src/resources/data.txt";
    //object
    public static HashMap<String, Account> map = new HashMap<>();

    //get data from local storage HashMap
    public static HashMap<String, Account> getData() {
        return map;
    }


    public void AddClientServiceToDatabase {

        //object = {email, {id, password, balance}}
        HashMap<String, Account> map = new HashMap();

        public void createAccount(String email) {
            Account newClient = new Account();
            //(email, Account{id, password, balance})
            map.put(email, newClient);
        }
    }


    public UsersDao Read(String userName){
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            Object userInfo =  fileInput.readObject();
            fileInput.close();
            System.out.println("Have been Read");
            //data.get(userName).getUserInfo();
            return (Account) map.get(userName);
        }
        catch(FileAlreadyExistsException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void UsersDao Write(String userName, Account user){
        try {
            ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
            map.put(userName, user);
            System.out.println("Have been Written");
            fileOutput.writeObject(map);
            fileOutput.close();

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}




