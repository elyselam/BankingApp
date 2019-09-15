package com.company.app.screens.employee;

import com.company.app.screens.LoginScreen;
import com.company.app.services.AddClientService;
import com.company.app.services.BalanceUpdateService;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddClientScreen {
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("What is the customer email?");
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


        AddClientService addEmail = new AddClientService();

        //takes in email and creates a unique account
        addEmail.createAccount(i);

        //after successfully adding account, confirms client has been added and send them to LoginScreen

        System.out.println("successfuly added!");
    }
}
