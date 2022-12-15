package com.banksystem.service;

import com.banksystem.model.Customer;
import com.banksystem.model.request.CustomerRequest;
import com.banksystem.model.request.CustomerRequest;

import java.sql.SQLException;

public interface CustomerService {
    void showAllCustomer() throws SQLException;
    Customer findCustomer(String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void createNewCustomer(CustomerRequest customerRequest) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

}
