package com.banksystem.repository;

import com.banksystem.JDBC.DBConnection;
import com.banksystem.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepository extends AbstractRepository implements CrudRepository<Customer , String> {


    Statement myStmt;
    ResultSet rs;

    DBConnection connection = new DBConnection();
    Connection con = connect();

    public CustomerRepository() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public Connection connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        DBConnection.getInstance();
        return connection.connect();

    }

    @Override
    public void save(Customer customer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection con = DBConnection.getInstance();
        myStmt = con.createStatement();
        rs = null;
        if (con == null){
            System.out.println("Connection is null");
        }

        String sql = "INSERT INTO customer(lastName,firstname,nationalcode) VALUES" +
                " ('"+  customer.getLastName()+"','"+customer.getFirstName() +"', '"+ customer.getNationalCode() +"')";
        System.out.println(sql);
        myStmt.executeUpdate(sql);
        System.out.println("Insert complete");
    }

    @Override
    public Customer find(String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (con == null) {
            System.out.println("Connection is null");
        }
        String sql = "SELECT * FROM customer WHERE nationalCode = '" + nationalCode + "'";
        Statement statement = con.createStatement();
        rs = statement.executeQuery(sql);

        String name = null;
        String firstname = null;
        String nationalcode = null;
        int id = 0;
        while (rs.next()) {
            id = rs.getInt("ID");
            name = rs.getString("LASTNAME");
            firstname = rs.getString("FIRSTNAME");
            nationalcode = rs.getString("NATIONALCODE");
            System.out.println(name + "\t" + firstname + "\t" + nationalcode);

        }return Customer.builder().firstName(firstname).lastName(name).nationalCode(nationalcode).id(id).build();

    }
    @Override
    public void findAll() throws SQLException {
        if (con == null){
            System.out.println("Connection is null");
        }
        String sql = "SELECT * FROM customer";
        Statement statement = con.createStatement();
        rs = statement.executeQuery(sql);
        while (rs.next()){
            String name = rs.getString("LASTNAME");
            String firstname = rs.getString("FIRSTNAME");
            String nationalcode = rs.getString("NATIONALCODE");
            System.out.println(name + "\t" + firstname + "\t" +  nationalcode);


        }




    }
}

