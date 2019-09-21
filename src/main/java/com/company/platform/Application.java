package com.company.platform;

import com.company.app.dao.UserRepository;
import com.company.app.models.Account;
import com.company.app.models.Users;
import com.company.app.services.AccountServices;
import com.company.app.services.CreateUserService;
import com.company.app.services.CustomerLoginService;
import com.company.app.services.EmailService;

public abstract class Application {

    //create service references
    protected AccountServices accountServices;
    protected CustomerLoginService customerLoginService;
    protected CreateUserService createUserService;


    //getters for services
    public AccountServices getAccountServices() {
        return accountServices;
    }
    public CustomerLoginService getCustomerLoginService() {
        return customerLoginService;
    }
    public CreateUserService getCreateUserService() { return createUserService; }





    private Users currentUser;
    private Account currentAccount;
    public Users getCurrentUser() { return currentUser; }
    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }
    public Account getCurrentAccount() {
        return currentAccount;
    }
    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
    }

    public abstract void run(String[] args);

}
