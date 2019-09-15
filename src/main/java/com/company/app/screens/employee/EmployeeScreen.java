package com.company.app.screens.employee;

import com.company.app.screens.LoginScreen;
import com.company.app.services.AddClientService;
import com.company.app.services.BalanceUpdateService;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeScreen implements Screen {


    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome back! How can we help you today?");
        String menuText = "";
        menuText = new StringMenuBuilder().
                addOption("1", "CreateAccount").
                addOption("2", "Exit")
                .build();

        System.out.println(menuText);

        Screen screen = null;
        try {
            screen = doInput(scanner);
        } catch (InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
        } catch (RuntimeException ex) {
            System.out.println(ex);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return screen;
    }

    @Override
    public Screen doInput(Scanner scanner) throws Exception {
        String i = scanner.next();
        Screen newScreen = null;
        BalanceUpdateService bal = new BalanceUpdateService();

        //AddClientService
        if (i.equals("1")){
            AddClientService addClient = new AddClientService();
            createAccount()

         //exit
        } else {
            newScreen = new LoginScreen();
        }

    }
}
