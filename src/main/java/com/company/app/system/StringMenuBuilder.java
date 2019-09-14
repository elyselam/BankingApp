package com.company.app.system;

import com.company.platform.MenuBuilder;

public class StringMenuBuilder implements MenuBuilder {

    private StringBuilder state;
    private String delimiter = "\n";

    public StringMenuBuilder() {

        state = new StringBuilder();
    }

    @Override
    public String build() {
        return state.toString();
    }

    /*
        add an option to the state with the following format
        key. value delimiter
        //
        LoginScreen
        addOption("1", "Login")

        //
        CustomerHomeScreen
        addOption("1", "Deposit")
        addOption("2", "Withdraw")
        addOption("3", "View Balance")
        addOption("4", "View Transaction History")
        addOption("5", "Exit")

        //
        EmployeeHomeScreen
        addOption("1", "CreateAccount")
        addOption("2", "ReviewCreditRequests")
        addOption("3", "Exit")

     */
    public StringMenuBuilder addOption(String key, String value) {
        state.append(String.format("%s. %s %s", key, value, delimiter));

        //returns object that was instantiated in StringBuilder class which contains 'state' variable
        return this;
    }
}