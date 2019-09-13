package com.company.app.screens;

import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.Scanner;

public class WelcomeScreen implements Screen {
    @Override
    public void Screen WelcomeScreen(Scanner scanner, Application app) {
        System.out.println("Welcome to " + app.getTitle());
        System.out.println("please log in");

    }



//    public Screen doInput(Scanner scanner) throws Exception {
//        String i = scanner.next();
//
//        Screen newScreen = null;
//        //if customer
//        if (i.equals("customer")){
//            newScreen = new CustomerHomeScreen();
//            //else must be employee
//        } else if (i.equals("employee")) {
//            newScreen = new EmployeeScreen();
//        } else {
//            newScreen = new WelcomeScreen();
//        }
//        return newScreen;
//    }
}

