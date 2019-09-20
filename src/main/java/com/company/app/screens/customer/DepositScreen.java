package com.company.app.screens.customer;
import com.company.app.models.Account;

import com.company.app.services.AccountServices;
import com.company.platform.Application;
import com.company.platform.Screen;
import java.util.InputMismatchException;
import java.util.Scanner;



public class DepositScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("How much would you like to deposit?");
        Screen screen = null;

        try {
            screen = doInput(scanner, app);
        } catch (InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return screen;
    }

    public Screen doInput(Scanner scanner, Application app) throws Exception {
        double sum = scanner.nextDouble();
        Screen newScreen = null;

        //take amount input and pass into AccountService
        AccountServices doDeposit = app.getAccountServices();
        Account acct = app.getCurrentAccount();

        doDeposit.deposit(acct, sum);

        //then confirms receipt
        System.out.println("Deposit of $" + sum + " is successful");
        System.out.println("Your balance is now $" + acct.getBalance());

        //and return to CustomerHomeScreen after successful deposit
        return new CustomerHomeScreen();
    }
}

