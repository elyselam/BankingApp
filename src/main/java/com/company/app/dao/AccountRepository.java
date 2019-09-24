package com.company.app.dao;

import com.company.app.models.Account;

public interface AccountRepository extends Repository<Account> {
    public Account getByEmail(String email);
}
