package com.company.app.models;
import java.io.Serializable;
//email, password
//CustomerLoginScreen


public class Users implements Serializable {
    private String email;
    private final int accountID;
    private int password;

    public Users(String email, String password, int accountID) {
        this.email = email;
        this.password = password.hashCode();
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }


}
