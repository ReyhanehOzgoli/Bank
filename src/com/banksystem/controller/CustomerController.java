package com.banksystem.controller;

import com.banksystem.model.Customer;
import com.banksystem.model.request.CustomerRequest;
import com.banksystem.model.request.CustomerRequest;
import com.banksystem.service.CustomerService;
import com.banksystem.service.Implement.CustomerServiceImplement;

import java.sql.SQLException;

public class CustomerController {

    CustomerService customerService = new CustomerServiceImplement();

    public CustomerController() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public void createCustomer(CustomerRequest customerRequest) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        customerService.createNewCustomer(customerRequest);

    }
    public Customer findCustomer(String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return customerService.findCustomer(nationalCode);
    }

    public void findAllCustomer() throws SQLException {
        customerService.showAllCustomer();

    }
}
