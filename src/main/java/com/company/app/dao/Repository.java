package com.company.app.dao;

import java.util.Collection;

public interface Repository<T> {
    T findById(int id);
    Collection<T> findAll();
    int save(T obj);
    void delete(T obj);
}
