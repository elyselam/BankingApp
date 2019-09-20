package com.company.app.screens.customer;

import com.company.app.models.Users;
import com.company.app.services.CustomerLoginService;
import com.company.app.services.EmailService;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerLoginScreen implements Screen{

    private CustomerLoginService loginService;

    public Screen doScreen(Scanner scanner, Application app) {
        loginService = app.getCustomerLoginService();

        System.out.println("Please enter your email");

        Screen screen = null;

        try {
            screen = doInput(scanner, app);
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
        } catch(RuntimeException ex){
            ex.printStackTrace();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return screen;
    }


    public Screen doInput(Scanner scanner,Application app) throws Exception {
        String email = scanner.next();
        //test email for validity
        if(!(new EmailService().checkEmailFormat(email))) {
            System.out.println("invalid email");
            return new CustomerLoginScreen();
        }
        System.out.println("Please enter your password");
        String password = scanner.next();

        //calls login() in login service
        Users user = loginService.login(email, password, app);

        if(user == null) {
            System.out.println("invalid password");
            return new CustomerLoginScreen();
        } else {
            app.setCurrentUser(user);
            return new CustomerHomeScreen();
        }
    }
}
