package com.company.platform;

import com.company.app.dao.AccountDao;

public abstract class Application {

    protected String title;

    public abstract void run(String[] args);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private UserDao userDao = new UserDao();
    private AccountDao accountDao = new AccountDao();

    public UserDao getUsersDao() {
        return userDao;
    }

    public void setUserDao(UserDao usersDao) {
        this.userDao = userDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



}
