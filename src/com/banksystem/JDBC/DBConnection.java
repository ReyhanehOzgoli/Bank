package com.banksystem.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements BankAppConnection {
    private static String URL = "jdbc:mysql://localhost:3306/Bank";
    private static String username = "root";
    private static String password = "Reyhaneh";
    private static Connection myConn;


    public static Connection getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (myConn == null) {
            try {
                //1. Get a connection to database
                myConn = DriverManager.getConnection(URL, username, password);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return myConn;

    }

    @Override
    public Connection connect() {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return myConn;
    }
}


