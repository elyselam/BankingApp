package com.company.app.system;

import com.company.app.dao.*;
import com.company.app.models.Account;
import com.company.app.models.Users;
import com.company.app.screens.WelcomeScreen;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.HashMap;
import java.util.Map;
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

        while(currentScreen != null) {
            //invokes doScreen on currentScreen
            //this is the current instance of BookstoreApplication, and it's 'app'
            //object whose parent is Application
            //has to be type Application
            //implicit upcast from BookstoreApplication to Application
            currentScreen = currentScreen.doScreen(scanner, this);
        }
    }
}

