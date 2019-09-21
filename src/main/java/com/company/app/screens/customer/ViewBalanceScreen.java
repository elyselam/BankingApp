package com.company.app.screens.customer;


import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewBalanceScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {

        System.out.println("\n" + "You have a balance of $"+app.getCurrentAccount().getBalance());
        System.out.println("\n" + "What else would you like to do?");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1", "Deposit")
                .addOption("2", "Withdraw")
                .addOption("3", "Back")
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
            newScreen = new CustomerHomeScreen();
        }else if (input.equals("4")) {
            System.out.println("goodbye!");
            newScreen = new CustomerLoginScreen();
        }else{
            newScreen = new ViewBalanceScreen();
        }
        return newScreen;
    }
}


