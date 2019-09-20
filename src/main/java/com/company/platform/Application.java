package com.company.platform;

import com.company.app.dao.AccountDao;
import com.company.app.dao.UserDao;
import com.company.app.models.Account;
import com.company.app.models.Users;
import com.company.app.services.AccountServices;
import com.company.app.services.CustomerLoginService;
import com.company.app.services.EmailService;

public abstract class Application {

    private Users currentUser;
    private Account currentAccount;

    //create service references
    protected AccountServices accountServices;
    protected CustomerLoginService customerLoginService;
    protected EmailService emailService;

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

    public AccountServices getAccountServices() {
        return accountServices;
    }

    public CustomerLoginService getCustomerLoginService() {
        return customerLoginService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public abstract void run(String[] args);

}
