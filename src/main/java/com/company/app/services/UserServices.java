package com.company.app.services;

import com.company.app.models.Users;

public class UserServices {

    public UserServices(String email, String password) {

        UserDao.getUserFromEmail(email) != null;
        if UserDao.getUserFromEmail(email).password().equals(password);
    }
}
