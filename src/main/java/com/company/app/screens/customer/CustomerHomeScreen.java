package com.company.app.screens.customer;

import com.company.app.dao.AccountDao;
import com.company.app.services.AccountService;
import com.company.app.services.AccountServices;
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
            screen = doInput(scanner);
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


    public Screen doInput(Scanner scanner) throws Exception {
        String i = scanner.next();
        Screen newScreen = null;
        AccountServices bal = new AccountServices();
        AccountDao accountDao = new AccountDao();

        //deposit
        //intake amount,
        //confirms intake with new balance
        if (i.equals("1")){
            return bal.deposit();

        //withdraw
        } else if (i.equals("2")) {
            return bal.withdrawal();

        //viewBalance
        } else if (i.equals("3")) {
        return accountDao.getBalance();

        //exit and returns to LoginScreen
        } else if (i.equals("4")) {
            newScreen = new CustomerHomeScreen;

    }
        return newScreen;
}
