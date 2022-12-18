package com.banksystem.repository;

import com.banksystem.JDBC.DBConnection;
import com.banksystem.model.Customer;
import com.banksystem.model.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionRepository extends AbstractRepository implements  CrudRepository<Transaction, String> {

    Statement myStmt;
    ResultSet rs;


    @Override
    public void save(Transaction transaction) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection con = DBConnection.getInstance();
        myStmt = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("Connection is null");
        }

        String sql = "INSERT INTO Account(accountNumber,shebaNumber,cashBalance,customerID) VALUES" +
                " ('"+  transaction.getTransactionDate()
                +"','"+transaction.getTransactionDescription()
                +"', '"+ transaction.getTransactionAmount()
                +"','"+ transaction.isTransactionStatus()+"')";
        System.out.println(sql);
        myStmt.executeUpdate(sql);
        System.out.println("Insert complete");



    }

    @Override
    public Transaction find(String s) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return null;
    }


    @Override
    public void findAll(){

    }
}
