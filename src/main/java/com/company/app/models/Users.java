package com.company.app.models;

//email, password
//CustomerLoginScreen


import java.io.Serializable;

public class Users implements Serializable {
    private String email;
    private String password;

    public Users() {

    }
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
