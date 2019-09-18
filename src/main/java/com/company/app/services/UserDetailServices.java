package com.company.app.services;

import com.company.app.dao.UserRepository;
import com.company.app.models.Users;
import com.company.app.dao.UserDao;

public class UserDetailServices {
    private UserRepository dao;

    public UserDetailServices() {}
    //set UserDao
    public void setDao(UserRepository dao) {
        this.dao = dao;
    }
    //
    public Users getUserByEmail(String email, String password) {

        //email, password inputted from CustomerLoginScreen



//        UserDao.getUserFromEmail(email) != null;
//        if UserDao.getUserFromEmail(email).password().equals(password);
        return null;
    }
}
