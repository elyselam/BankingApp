package com.company.app.dao;

import com.company.app.models.Account;
import com.company.app.models.Users;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class UserDao implements UserRepository {
    @Override
    public Users save(Users o) {
        return null;
    }

    @Override
    public Users getById(int id) {
        return null;
    }

    @Override
    public Collection<Users> getAll() {
        return null;
    }

    @Override
    public void delete(Users o) {

    }

    @Override
    public Users getByEmail(String email) {
        return null;
    }


//public class UserDao implements DaoInterface {
//    //protected AccountInfo user;
//    public static final String file = "src/resources/data.txt";
//
//    //constructor
//    public HashMap<String, Users> map = new HashMap();
//
//    public void getData(String email){
//        return map;
//    }
//
//    public void setData(String email) {
//        //set password to email
//    }
//
//
//    //read from file
//    public Account Read(String email){
//        try {
//            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
//            Object userInfo =  fileInput.readObject();
//            fileInput.close();
//            System.out.println("Have been Read");
//            //data.get(userName).getUserInfo();
//            return (Account) map.get(email);
//        }
//        catch(FileAlreadyExistsException e){
//            e.printStackTrace();
//        }
//        catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //write to file with email input and password
//    public void Write(String email, String password){
//        try {
//            ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
//            Users user = new Users(email, password);
//            map.put(email, user);
//            System.out.println("Have been Written");
//            fileOutput.writeObject(map);
//            fileOutput.close();
//        }
//        catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//    }
}

