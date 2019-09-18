package com.company.app.dao;

import com.company.app.models.Users;

import java.util.Collection;

public class UserJDBCDao implements UserRepository {
    @Override
    public Users getByEmail(String email) {
        return null;
    }

    @Override
    public Users save(Users o) {
        return null;
    }

    @Override
    public Users getById(int id) {
        return null;
    }

    @Override
    public Collection<Users> getAll() {
        return null;
    }

    @Override
    public void delete(Users o) {

    }

    // don't forget to override you methods
}
