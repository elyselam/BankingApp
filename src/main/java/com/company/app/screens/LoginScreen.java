package com.company.app.screens;

import com.company.app.screens.customer.CustomerHomeScreen;
import com.company.app.screens.employee.EmployeeScreen;
import com.company.platform.Application;
import com.company.platform.Screen;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Please log in");
        Screen screen = null;
        try {
            screen = doInput(scanner);
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


    public Screen doInput(Scanner scanner) throws Exception {
        String i = scanner.next();
        Screen newScreen = null;
        //if input is "customer"
        if (i.equals("customer")){
            newScreen =  new CustomerHomeScreen();

            //if input is "employee"
        } else if (i.equals("employee")) {
            newScreen = new EmployeeScreen();

            //else go back to WelcomeScreen
        } else {
            newScreen = new LoginScreen();
        }
        return newScreen;
    }
}
