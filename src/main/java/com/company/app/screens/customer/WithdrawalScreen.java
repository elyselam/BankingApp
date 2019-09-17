package com.company.app.screens.customer;
import com.company.app.services.BalanceUpdateService;

import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawalScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("How much would you like to withdraw?");


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
        String inputAmount = scanner.next();

        BalanceUpdateService bal = new BalanceUpdateService();

        //withdraw
        //intake amount from scanner
        //confirms intake with new balance

        System.out.println("You withdrew successfully! Your remaining amount is: " );
        return new CustomerHomeScreen();


    }
}

