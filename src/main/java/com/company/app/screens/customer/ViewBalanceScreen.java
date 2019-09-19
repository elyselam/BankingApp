package com.company.app.screens.customer;

import com.company.app.dao.AccountDao;
import com.company.app.dao.UserDao;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Screen;

import java.util.InputMismatchException;

public class ViewBalanceScreen {

    UserDao userDao;
    AccountDao accountDao;

    public Screen doScreen(Scanner scanner, Application app) {
        userDao = app.getUserDao();
        accountDao = app.getAccountDao();


        System.out.println("Welcome back! How can we help you today?");


        Screen screen = null;
        try {
            screen = doInput(scanner, app);
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
        } catch(RuntimeException ex){
            System.out.println(ex);

        }catch(Exception ex) {
            System.out.println(ex);
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
        }
        System.out.println("goodbye!");
        newScreen = new CustomerLoginScreen();
        return newScreen;

    }

}

}
