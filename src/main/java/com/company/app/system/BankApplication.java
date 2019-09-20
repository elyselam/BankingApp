package com.company.app.system;

import com.company.app.dao.*;
import com.company.app.screens.WelcomeScreen;
import com.company.app.services.AccountServices;
import com.company.app.services.CreateUserService;
import com.company.app.services.CustomerLoginService;
import com.company.app.services.EmailService;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.Scanner;

public class BankApplication extends Application {

    //set current user and subuser
    private Screen currentScreen;

    private Scanner scanner;

    public BankApplication() {
        currentScreen = new WelcomeScreen();
        scanner = new Scanner(System.in);
    }

    public void run(String[] args) {
        //make the connection between services and corresponding daos
        init();

        while(currentScreen != null) {
            //invokes doScreen on currentScreen
            //this is the current instance of BookstoreApplication, and it's 'app'
            //object whose parent is Application
            //has to be type Application
            //implicit upcast from BookstoreApplication to Application
            currentScreen = currentScreen.doScreen(scanner, this);
        }
    }

    private void init() {
//        //Phase 1
//        UserRepository userRepositoryFIO = new UserDao();
//        AccountRepository accountRepositoryFIO = new AccountJDBCDao();

        //Phase 2
        UserJDBCDao userRepository = new UserJDBCDao();
        AccountJDBCDao accountRepository = new AccountJDBCDao();

        accountServices = new AccountServices();
        accountServices.setAccountJDBCDao(accountRepository);

        createUserService = new CreateUserService();
        createUserService.setUserJDBCDao(userRepository);
        createUserService.setAccountJDBCDao(accountRepository);

        customerLoginService = new CustomerLoginService();
        customerLoginService.setUserJDBCDao(userRepository);
        customerLoginService.setAccountJDBCDao(accountRepository);

        emailService = new EmailService();




    }
}

