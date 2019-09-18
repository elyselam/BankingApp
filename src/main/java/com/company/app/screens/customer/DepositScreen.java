package com.company.app.screens.customer;
import com.company.app.dao.AccountDao;
import com.company.app.services.BalanceUpdateService;

import com.company.platform.Application;
import com.company.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DepositScreen implements Screen {

    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("How much would you like to deposit?");
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

        //key on email of local database stored in Dao
        AccountDao currentUser = new AccountDao();

        //object = {email, {id, balance}}
        currentUser.AddClientService.clientList.get()


        BalanceUpdateService bal = new BalanceUpdateService();

        //deposit
        //intake amount from scanner
        //confirms intake with new balances
       bal.deposit(currentUser, inputAmount);

        System.out.println("Deposit completed. Your remaining amount is: " + bal.getAmount());


       return new CustomerHomeScreen();

    }
}

