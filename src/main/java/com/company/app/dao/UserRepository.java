package com.company.app.dao;

import com.company.app.models.Users;
//link user email from UserDao to AccountDao

public interface UserRepository extends Repository<Users> {
    public Users getByEmail(String email);
}
