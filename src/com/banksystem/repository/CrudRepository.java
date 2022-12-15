package com.banksystem.repository;

import com.banksystem.model.Customer;

import java.sql.SQLException;

public interface CrudRepository<T, E>{
    public void save(T t) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    public T find(E e) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    public void findAll() throws SQLException;
}
