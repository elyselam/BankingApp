package com.company.app.services;
import com.company.app.dao.AccountDao;
import com.company.app.dao.UserDao;
import com.company.app.models.Users;
import com.company.app.screens.customer.CustomerHomeScreen;
import com.company.app.screens.customer.CustomerLoginScreen;
import com.company.platform.Application;
import com.company.platform.Screen;

public class CustomerLoginService {

    public Screen login(String email, String password, Application app) {

        UserDao userDao = app.getUserDao();
        AccountDao accountDao = app.getAccountDao();

        Users user = userDao.getUser(email);
        //if checkPassword returns true, set currentUser as this user
        //and send to CustomerHomeScreen
        //else, make them log in again
        System.out.println(user);

        if (userDao.checkEmailAndPassword(email, password)) {

            app.setCurrentUser(user);

            return new CustomerHomeScreen();
        }
        else {
            System.out.println("Invalid email/password!");
        }
        //make them log in again
        return new CustomerLoginScreen();
    }
}
