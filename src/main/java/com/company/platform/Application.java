package com.company.platform;

import com.company.app.dao.AccountDao;
import com.company.app.dao.UserDao;
import com.company.app.models.Account;
import com.company.app.models.Users;

public abstract class Application {

    private Users currentUser;
    private Account currentAccount;
    private UserDao userDao = new UserDao();
    private AccountDao accountDao = new AccountDao();

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }



    public UserDao getUserDao() {
        return userDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }
    public abstract void run(String[] args);

}
