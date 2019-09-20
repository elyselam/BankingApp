package com.company.app.screens.customer;

import com.company.app.dao.AccountDao;
import com.company.app.dao.UserDao;
import com.company.app.models.Account;
import com.company.app.models.Users;
import com.company.app.services.CustomerLoginService;
import com.company.app.system.BankApplication;
import com.company.platform.Application;
import com.company.platform.Screen;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

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
            System.out.println(ex);

        }catch(Exception ex) {
            System.out.println(ex);
        }
        return screen;
    }


    public Screen doInput(Scanner scanner,Application app) throws Exception {
        String email = scanner.next();
        System.out.println("Please enter your password");
        String password = scanner.next();

        //calls login() in login service
        Users u = loginService.login(email, password, null);

        if(u == null) {
            return new CustomerLoginScreen();
        } else {
            app.setCurrentUser(u);
            return new CustomerHomeScreen();
        }
    }
}
