package com.company.app.models;
import java.io.Serializable;
//email, password
//CustomerLoginScreen


public class Users implements Serializable {
    private String email;
    int accountID;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
