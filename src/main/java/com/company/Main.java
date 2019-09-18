package com.company;

import com.company.app.system.BankApplication;
import com.company.platform.Application;


public class Main {

    public static void main(String[] args) {
        Application app = new BankApplication();

        app.run(args);
    }
}
