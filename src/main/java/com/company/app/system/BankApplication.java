package com.company.app.system;

import com.company.app.dao.*;
import com.company.app.models.Users;
import com.company.app.screens.WelcomeScreen;
import com.company.app.services.UserAuthenticateServices;
import com.company.app.services.UserDetailServices;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankApplication extends Application {
    private Screen currentScreen;
    private Scanner scanner;
    Map<String, Object> context = new HashMap<>();

    public BankApplication() {
        currentScreen = new WelcomeScreen();
        scanner = new Scanner(System.in);

    }

    @Override
    public void run(String[] args) {

        initContext();

        while(currentScreen != null) {
            //invokes doScreen on currentScreen
            //this is the current instance of BookstoreApplication, and it's 'app'
            //object whose parent is Application
            //has to be type Application
            //implicit upcast from BookstoreApplication to Application
            currentScreen = currentScreen.doScreen(scanner, this);
        }
    }

    public Map<String, Object> getContext() { return context; }

    private void initContext() {
        //create instances of all of your services
        //and daos and resolve their relations ships
        // Service s = new Service1()
        // Dao d = new Dao1()
        // s.setDao(d);
        // context.put("myService", s);

        //assign Dao
        Repository<Users> userDao = new UserJDBCDao();

        UserDetailServices userDeets = new UserDetailServices();
        //cast UserRepository type, set user details to userDao
        userDeets.setDao((UserRepository)userDao);


        UserAuthenticateServices userAuth = new UserAuthenticateServices();
        //pass user details into authentication
        userAuth.setUserDetailServices(userDeets);

        //put String, and object we want to link up
        context.put("userDetailService", userDeets);
        context.put("userAuthService", userAuth);
    }

}

