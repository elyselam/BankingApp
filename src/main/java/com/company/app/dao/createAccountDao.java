package com.company.app.dao;

import jdk.nashorn.internal.runtime.ECMAException;

import java.io.*;

public class createAccountDao {

    //clientList
    public void writeObject(String filename, Object obj){
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))){
            output.writeObject(obj);
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
            return objInput;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}




