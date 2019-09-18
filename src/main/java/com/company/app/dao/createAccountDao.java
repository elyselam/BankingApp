package com.company.app.dao;

import com.company.app.models.Account;

import java.io.*;
import java.util.HashMap;

public class createAccountDao {

    //output file
    public static final String filename = "src/resources/data.txt";
    //object
    public static HashMap<String, Account> clientList = new HashMap<>();

    //get data from local storage HashMap
    public static HashMap<String, Account> getData() {
        return clientList;
    }


    public void AddClientServiceToDatabase {

        //object = {email, {id, password, balance}}
        HashMap<String, Account> clientList = new HashMap();

        public void createAccount(String email) {
            Account newClient = new Account();
            //(email, Account{id, password, balance})
            clientList.put(email, newClient);
        }


    }

    //clientList
    public void writeObject(String filename, Object clientList){
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))){
            output.writeObject(clientList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject(String filename){
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))){
            Object objInput = input.readObject();
            input.close();
            System.out.println("data been read");
            return objInput;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}




