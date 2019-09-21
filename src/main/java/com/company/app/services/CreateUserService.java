package com.company.app.services;

import com.company.app.dao.AccountJDBCDao;
import com.company.app.dao.AccountRepository;
import com.company.app.dao.UserJDBCDao;
import com.company.app.dao.UserRepository;
import com.company.app.screens.employee.EmployeeScreen;
import com.company.app.system.BankApplication;

import java.util.Scanner;

public class CreateUserService {

    private AccountJDBCDao accountJDBCDao ;
    private UserJDBCDao userJDBCDao;

    public void setUserJDBCDao(UserJDBCDao userJDBCDao) {
        this.userJDBCDao = userJDBCDao;
    }
    public void setAccountJDBCDao(AccountJDBCDao accountJDBCDao) {
        this.accountJDBCDao = accountJDBCDao;
    }

    public void createUser(Scanner scanner, String email, String password) {
        //check if email has valid format
        if(!(new EmailService()).checkEmailFormat(email)){
            System.out.println("invalid email");
        }
        //set id, createNewAccount
        int id = accountJDBCDao.createNewAccount(email);
        //id is returned from createNewAccount(email). referencing that account
        userJDBCDao.createNewUser(email,password, id);
        //now can key on id in User

        System.out.println("User created");
    }
    //save email and password from CustomerLoginScreen
    //generate an id
    //save to map



}
