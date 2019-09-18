package com.company.app.dao;

import com.company.app.models.Account;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class AccountDao implements DaoInterface{

    //output file
    public static final String file = "src/resources/data.txt";
    //object
    public HashMap<Integer, Account> map = new HashMap<>();


    public void AccountDao {
        //object = {email, {id, password, balance}}

        public void AccountDao() {
            Account newAccount = new Account();
            //(Account{id, password, balance})
            map.put( , newAccount);
        }
    }











    public UsersDao Read(String userName){
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            Object userInfo =  fileInput.readObject();
            fileInput.close();
            System.out.println("Have been Read");

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




