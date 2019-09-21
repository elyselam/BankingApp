package com.company.app.services;
import com.company.app.dao.AccountJDBCDao;
import com.company.app.dao.AccountRepository;
import com.company.app.dao.UserRepository;
import com.company.app.models.Account;
import com.company.app.models.Users;
import com.company.app.screens.customer.CustomerHomeScreen;
import com.company.app.screens.customer.CustomerLoginScreen;
import com.company.platform.Application;

public class CustomerLoginService {

    private UserRepository userDao;
    private AccountJDBCDao accountDao;
    public CustomerLoginService() {}

    public void setUserJDBCDao(UserRepository userDao) {
        this.userDao = userDao;
    }
    public void setAccountJDBCDao(AccountJDBCDao accountDao) {
        this.accountDao = accountDao;
    }

    public Users login(String email, String password, Application app) {

        Users user = userDao.getByEmail(email);
        int id = user.getId();
        Account currentAccount = accountDao.getAccount(id);
        //if checkPassword returns true, set currentUser as this user
        //and send to CustomerHomeScreen
        //else, make them log in again


        if (userDao.getByEmail(email) != null) {
            app.setCurrentUser(user);
            app.setCurrentAccount(currentAccount);
            return user;
        }
        else {
            System.out.println("Invalid email/password!");
        }
        //make them log in again
        return null;
    }
}
