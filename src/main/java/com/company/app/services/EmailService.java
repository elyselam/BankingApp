package com.company.app.services;

import com.company.app.dao.AccountJDBCDao;
import com.company.app.dao.UserRepository;

public class EmailService {

    public boolean checkEmailFormat(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
