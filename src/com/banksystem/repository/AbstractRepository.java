package com.banksystem.repository;

import com.banksystem.JDBC.DBConnection;
import com.banksystem.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractRepository {
    public DBConnection dbConnection = new DBConnection();

    public Connection connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        DBConnection.getInstance();
        return dbConnection.connect();
    }

}

