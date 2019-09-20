package com.company.app.services;

import com.company.app.dao.AccountDao;
import com.company.app.dao.UserRepository;

public class EmailService {

    public void setUserDao(UserRepository userDao) {
        this.userDao = userDao;
    }

    private UserRepository userDao;
    private AccountDao accountDao;


    public boolean checkEmailFormat(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
