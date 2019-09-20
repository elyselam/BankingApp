package com.company.app.screens.employee;

import com.company.app.screens.WelcomeScreen;

import com.company.app.screens.customer.CustomerLoginScreen;
import com.company.app.services.CreateUserService;
import com.company.app.services.EmailService;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeScreen implements Screen {

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
            screen = doInput(scanner, app);
        } catch (InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
        } catch (RuntimeException ex) {
            ex.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return screen;
    }


    public Screen doInput(Scanner scanner, Application app) throws Exception {
        Screen newScreen = null;
        if (scanner.next().equals("1")){
            System.out.println("enter the email");
            String email = scanner.next();

            System.out.println("Please enter your password");
            String password = scanner.next();
            if(password.equals("")){
                System.out.println("password cannot be blank");
                return new EmployeeScreen();
            }

            app.createUserService().createUser(scanner, email, password);
            newScreen = new EmployeeScreen();
         //exit back to LoginScreen
        } else {
            newScreen = new WelcomeScreen();
        }
        return newScreen;
    }
}
