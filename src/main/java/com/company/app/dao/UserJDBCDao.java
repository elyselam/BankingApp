package com.company.app.dao;

import com.company.app.models.Users;

import java.util.Collection;

public class UserJDBCDao implements UserRepository {
    @Override
    public Users getByEmail(String email) {
        return null;
    }

    @Override
    public Users findById(int id) {
        return null;
    }

    @Override
    public Collection<Users> findAll() {
        return null;
    }

    @Override
    public int save(Users obj) {
        return 0;
    }

    @Override
    public void delete(Users obj) {

    }
}

    // don't forget to override you methods

