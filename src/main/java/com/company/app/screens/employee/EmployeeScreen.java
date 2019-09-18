package com.company.app.screens.employee;

import com.company.app.screens.WelcomeScreen;
import com.company.app.services.AddClientService;
import com.company.app.services.AccountService;
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


    public Screen doInput(Scanner scanner) throws Exception {
        String i = scanner.next();
        Screen newScreen = null;
        AccountService bal = new AccountService();


        if (i.equals("1")){
            newScreen = new AddClientScreen();
//            AddClientService addClient = new AddClientService();
//            addClient.clientList()

         //exit back to LoginScreen
        } else {
            newScreen = new WelcomeScreen();
        }
        return newScreen;
    }
}
