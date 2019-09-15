package com.company.app.dao;


import com.company.app.services.AddClientService;

import java.io.*;

public class createAccountDao {


    public void writeObject(String filename, Object obj) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)){
            oos.writeObject(obj)
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}




