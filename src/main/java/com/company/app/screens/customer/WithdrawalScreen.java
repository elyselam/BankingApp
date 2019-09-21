package com.company.app.screens.customer;
import com.company.app.models.Account;
import com.company.app.services.AccountServices;

import com.company.app.services.AccountServices;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawalScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("How much would you like to withdraw?");

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


    public Screen doInput(Scanner scanner, Application app) throws Exception {

        double sum = scanner.nextDouble();
        Screen newScreen = null;

        //take amount input and pass into AccountService
        AccountServices doWithdrawal = app.getAccountServices();
        Account acct = app.getCurrentAccount();

        doWithdrawal.withdrawal(acct, sum);

        //and return to CustomerHomeScreen after successful withdrawal
        return new CustomerHomeScreen();
    }
}

