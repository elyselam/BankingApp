package com.company.app.screens.employee;

import com.company.app.services.AccountServices;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddClientScreen implements Screen {
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Please type in customer email");
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

        AccountServices addEmail = new AccountServices();

        //takes in email and creates a unique account
        // adds to clientList
        addEmail.createAccount(i);

        //after successfully adding account, confirms client has been added and send them back to LoginScreen
        System.out.println("Account successfully added!");
        return newScreen;
    }
}
