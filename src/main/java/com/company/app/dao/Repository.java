package com.company.app.dao;

import java.util.Collection;

public interface Repository<T> {
    T save(T o);
    T getById(int id);
    Collection<T> getAll();
    void delete(T o);
}
