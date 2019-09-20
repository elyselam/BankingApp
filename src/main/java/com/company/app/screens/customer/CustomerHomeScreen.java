package com.company.app.screens.customer;

import com.company.app.screens.WelcomeScreen;

import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerHomeScreen implements Screen {


    public Screen doScreen(Scanner scanner, Application app) {


        System.out.println("Welcome back! How can we help you today?");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1", "Deposit")
                .addOption("2", "Withdraw")
                .addOption("3", "View Balance")
                .addOption("4", "Logout")
                .build();

        System.out.println(menuText);

        Screen screen = null;
        try {
            screen = doInput(scanner, app);
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
        } catch(RuntimeException ex){
            ex.printStackTrace();
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return screen;
    }


    public Screen doInput(Scanner scanner, Application app) throws Exception {
        Screen newScreen = null;
        String input = scanner.next();

        if (input.equals("1")) {
            newScreen = new DepositScreen();
        } else if (input.equals("2")) {
            newScreen = new WithdrawalScreen();
        } else if (input.equals("3")) {
           newScreen = new ViewBalanceScreen();
        } else if(input.equals("4") ) {
            newScreen = new WelcomeScreen();

            //log them out, reset current account
            app.setCurrentAccount(null);
            app.setCurrentUser(null);

        //if something random, back to 'welcome back!'
        } else {
            newScreen = new CustomerHomeScreen();
        }
        return newScreen;
    }
}
