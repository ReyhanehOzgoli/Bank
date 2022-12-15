package com.banksystem.repository;

import com.banksystem.JDBC.DBConnection;
import com.banksystem.model.Account;
import com.banksystem.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountRepository extends AbstractRepository implements CrudRepository<Account,String> {
    Statement myStmt;
    ResultSet rs;

    DBConnection connection = new DBConnection();
    Connection con = connect();

    public AccountRepository() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public Connection connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return connection.connect();

    }

    @Override
    public void save(Account account) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection con = DBConnection.getInstance();
        myStmt = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("Connection is null");
        }

        String sql = "INSERT INTO Account(accountNumber,shebaNumber,cashBalance,customerID) VALUES" +
                " ('"+  account.getAccountNumber()
                        +"','"+account.getShebaNumber()
                        +"', '"+ account.getCashBalance()
                        +"','"+ account.getCustomerID()+"')";
        System.out.println(sql);
        myStmt.executeUpdate(sql);
        System.out.println("Insert complete");
    }


    public List<Account> findCustomerAccounts(int customerId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection con = DBConnection.getInstance();
        myStmt = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("Connection is null");
        }

        String sql = "SELECT * FROM Account WHERE customerID = " + customerId;
        System.out.println(sql);
        rs = myStmt.executeQuery(sql);

        List<Account> accounts = new ArrayList<>();
        while (rs.next()){

            accounts.add(
            Account.builder()
                    .accountNumber(rs.getString("accountNumber"))
                    .cashBalance(rs.getLong("cashBalance"))
                    .shebaNumber(rs.getString("shebaNumber"))
                    .build());

        }return accounts;
    }
    @Override
    public Account find(String accountNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (con == null) {
            System.out.println("Connection is null");
        }
        String sql = "SELECT * FROM Account WHERE accountNumber = '" + accountNumber + "'";
        Statement statement = con.createStatement();
        rs = statement.executeQuery(sql);

        String shebaNumber = null;
        long cashBalance = 0;
        int customerID = 0;
        int id = 0;
        while (rs.next()) {
            id = rs.getInt("ID");
            customerID = rs.getInt("customerID");
            cashBalance = rs.getLong("cashBalance");
            shebaNumber = rs.getString("shebaNumber");
            System.out.println(customerID + "\t" + id + "\t" + cashBalance + "\t" + shebaNumber);

        }return Account.builder().customerID(customerID).id(id).cashBalance(cashBalance).shebaNumber(shebaNumber).build();
    }

    @Override
    public void findAll() throws SQLException {


    }
}
