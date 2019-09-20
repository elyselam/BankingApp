package com.company.app.models;
import java.io.Serializable;
//email, password
//CustomerLoginScreen


public class Users implements Serializable {
    private String email;

    private int password;

    public Users(String email, String password {
        this.email = email;
        this.password = password.hashCode();

    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }


}
