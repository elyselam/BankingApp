package com.company.app.screens.customer;

import com.company.app.services.BalanceUpdateService;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;



public class CustomerLoginScreen {
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Please enter your email and password");
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
        System.out.println("Please enter email");
        String email = scanner.next();

        //check if password matches

        System.out.println("Please enter password");
        String password = scanner.next();

        //

        //if all is valid, send to CustomerHomeScreen


        newScreen = new CustomerHomeScreen();



    }
}
