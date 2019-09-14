package com.company.app.screens.customer;

import com.company.app.models.Account;
import com.company.app.models.Customer;
import com.company.app.screens.LoginScreen;
import com.company.app.screens.employee.EmployeeScreen;
import com.company.app.services.BalanceUpdateService;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerHomeScreen implements Screen {
    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome back! How can we help you today?");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1", "Deposit")
                .addOption("2", "Withdraw")
                .addOption("3", "View Balance")
                .addOption("4", "View Transaction History")
                .addOption("5", "Logout")
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
        BalanceUpdateService bal = new BalanceUpdateService();

        if (i.equals("1")){
            return bal.deposit().;


        } else if (i.equals("2")) {
            return bal.withdrawal().;


        } else if (i.equals("3")) {
        return bal.viewBalance().;

        } else if (i.equals("4")) {
            return 0;
        }

        //if 5, Logout
        else {
            newScreen = new LoginScreen();
        }
        return newScreen;
    }
}
