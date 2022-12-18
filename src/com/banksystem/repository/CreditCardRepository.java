package com.banksystem.repository;

import com.banksystem.JDBC.DBConnection;
import com.banksystem.model.CreditCard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditCardRepository extends AbstractRepository implements CrudRepository<CreditCard,String>{
    Statement myStmt;
    ResultSet rs;

    DBConnection connection = new DBConnection();
    Connection con = connect();

    public CreditCardRepository() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void save(CreditCard creditCard) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection con = DBConnection.getInstance();
        myStmt = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("Connection is null");
        }

        String sql = "INSERT INTO CreditCard (cardNumber,CVV2,accountID,id) VALUES" +
                " ('"+creditCard.getCardNumber()
                +"','"+creditCard.getCVV2()
                +"', '"+ creditCard.getAccountID()
                +"','"+ creditCard.getId()+"')";
        System.out.println(sql);
        myStmt.executeUpdate(sql);
        System.out.println("Insert complete");
    }

    public String findAccountNumber(String cardNumber) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Connection con = DBConnection.getInstance();
        myStmt = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("Connection is null");
        }

        String sql = "SELECT accountNumber FROM Account INNER JOIN CreditCard ON" +
               " Account.ID = CreditCard.id"+
               " WHERE cardNumber =" + cardNumber;
        System.out.println(sql);
        myStmt.executeUpdate(sql);
        System.out.println("Insert complete");

        if (rs.next()) {
            String accountNumber = rs.getString("accountNumber");

            return accountNumber;
        }return null;
    }
    @Override
    public CreditCard find(String cardNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return null;
    }

    @Override
    public void findAll() throws SQLException {

    }
}
