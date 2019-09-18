package com.company.app.screens.customer;

import com.company.app.models.Users;
import com.company.app.services.UserAuthenticateServices;
import com.company.app.services.UserDetailServices;
import com.company.app.system.BankApplication;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;



public class CustomerLoginScreen implements Screen{
    private UserAuthenticateServices authService;
    public Screen doScreen(Scanner scanner, Application app) {
        authService = (UserAuthenticateServices)((BankApplication)app).getContext().get("userAuthService");
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



        System.out.println("Please enter password");
        String password = scanner.next();

        Users u = authService.auth(email, password);

        if(u == null) {
            // login failed
            return new CustomerLoginScreen();
        }

        //login successful
        return new CustomerHomeScreen();

    }
}
