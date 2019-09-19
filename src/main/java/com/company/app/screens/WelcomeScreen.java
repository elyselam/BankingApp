package com.company.app.screens;

import com.company.app.screens.customer.CustomerHomeScreen;
import com.company.app.screens.customer.CustomerLoginScreen;
import com.company.app.screens.employee.EmployeeScreen;
import com.company.app.system.StringMenuBuilder;
import com.company.platform.Application;
import com.company.platform.Screen;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Are you a customer or an employee?");
        String menuText = "";
        menuText = new StringMenuBuilder().
                addOption("1", "Customer").
                addOption("2", "Employee")
                .build();

        System.out.println(menuText);
        Screen screen = null;
        try {
            screen = doInput(scanner, app);
//            System.out.println(screen.doInput());
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
           //screen = new LoginScreen(scanner, app);
        } catch(RuntimeException ex){
            System.out.println(ex);

        }catch(Exception ex) {
            System.out.println(ex);
//        } finally {
//           // will always run
//            System.out.println("try again");
        }
        return screen;
    }


    public Screen doInput(Scanner scanner,Application app) throws Exception {
        String i = scanner.next();
        Screen newScreen = new WelcomeScreen();

        //if input is "customer"
        if (i.equals("1")){
            newScreen =  new CustomerLoginScreen();

            //if input is "employee"
        } else if (i.equals("2")) {
            //TODO newScreen = new EmployeeScreen();

        }
        return newScreen;
    }
}
