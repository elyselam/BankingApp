package com.company.app.dao;

import com.company.app.models.Account;

import java.io.*;
import java.util.HashMap;

public class AccountDao {

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
            clientList.put(email, newClient);
        }


    }

    //map
    public void writeObject(String filename, Object map){
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




