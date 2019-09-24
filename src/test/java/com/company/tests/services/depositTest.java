package com.company.tests.services;

import com.company.app.models.Account;
import com.company.app.services.AccountServices;
import com.company.app.services.AccountServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class depositTest {

    Account account = new Account();

    AccountServices balance;

    @Before
    public void init() {
        balance = new AccountServices();
    }

    @Test
    public void shouldUpdateBalance() {
        double expectedOutput = 5;
        account.setBalance(5);
        Assert.assertEquals("balance not updated", expectedOutput, account.getBalance());

    }
}
