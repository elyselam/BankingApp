package com.company.app.services;

import com.company.app.models.Users;

public class UserDetailServices {

    public UserDetailServices(String email, String password) {

        UserDao.getUserFromEmail(email) != null;
        if UserDao.getUserFromEmail(email).password().equals(password);
    }
}
