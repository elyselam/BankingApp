package com.company.app.dao;

import com.company.app.models.Users;

public interface UserRepository extends Repository<Users> {
    public Users getByEmail(String email);
}
