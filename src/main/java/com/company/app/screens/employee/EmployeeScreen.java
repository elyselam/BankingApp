package com.company.app.screens.employee;

import com.company.app.dao.AccountDao;
import com.company.app.dao.UserDao;
import com.company.app.screens.WelcomeScreen;

import com.company.app.services.AccountServices;
import com.company.app.services.EmailService;
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
            screen = doInput(scanner, app);
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


    public Screen doInput(Scanner scanner, Application app) throws Exception {
        Screen newScreen = null;

        if (scanner.next().equals("1")){
            System.out.println("enter the email");
            String email = scanner.next();

            if(!(new EmailService()).checkEmailFormat(email)){
                System.out.println("invaild email");
                return new EmployeeScreen();
            }
            System.out.println("enter the password");
            String password = scanner.next();
            
            int id = app.getAccountDao().createNewAccount(email);

            //id is returned from createNewAccount(email). referencing that account
            app.getUserDao().createNewUser(email,password, id);
            //now can key on id in User

            System.out.println("User created");
            newScreen = new EmployeeScreen();
         //exit back to LoginScreen
        } else {
            newScreen = new WelcomeScreen();
        }
        return newScreen;
    }
}
