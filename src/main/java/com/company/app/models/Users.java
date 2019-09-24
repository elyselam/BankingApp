package com.company.app.models;
import java.io.Serializable;
import java.util.Random;
//email, password
//CustomerLoginScreen


public class Users implements Serializable {
    private String email;

    private int id;
    private String password;

    public Users(String email, String password, int id) {
        this.email = email;
        this. id = id;
        this.password = password.hashCode()+"";
    }

    public int getId() { return id; }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
