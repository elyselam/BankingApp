package com.company.app.screens.customer;

import com.company.app.screens.LoginScreen;
import com.company.app.screens.employee.EmployeeScreen;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerHomeScreen implements Screen {
    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome back! How can we help you today?");
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

        return newScreen;
    }
}
