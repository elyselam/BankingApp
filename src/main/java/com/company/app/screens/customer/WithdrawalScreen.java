package com.company.app.screens.customer;
import com.company.app.models.Account;
import com.company.app.services.AccountService;

import com.company.app.services.AccountServices;
import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WithdrawalScreen implements Screen {
    Application app;

    public Screen doScreen(Scanner scanner, Application app) {
        this.app = app;
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

        double input = scanner.nextDouble();

        Screen newScreen = null;

        //take amount input and pass into DepositServices
        AccountServices doWithdrawal = new AccountServices(app);
        Account acct = new Account();

        doWithdrawal.withdrawal(acct, input);

        //then confirms receipt
        System.out.println("Withdrawal of " + input + "is successful");
        System.out.println("Your balance is now " + acct.getBalance());

        //and return to CustomerHomeScreen after successful withdrawal
        return new CustomerHomeScreen();

    }
}

