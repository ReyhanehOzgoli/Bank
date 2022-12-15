package com.banksystem.service.Implement;

import com.banksystem.model.Customer;
import com.banksystem.model.request.CustomerRequest;
import com.banksystem.model.request.CustomerRequest;
import com.banksystem.repository.CustomerRepository;
import com.banksystem.service.CustomerService;

import java.sql.SQLException;
import java.util.Random;

public class CustomerServiceImplement implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    public CustomerServiceImplement() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void showAllCustomer() throws SQLException {
        customerRepository.findAll();

    }

    @Override
    public Customer findCustomer(String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return customerRepository.find(nationalCode);


    }

    @Override
    public void createNewCustomer(CustomerRequest customerRequest) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {



        /*String fullName = customer.getFirstName() + customer.getLastName();
        customer.setFullName(fullName);*/
        //customer.setCIF(this.generateCIF(customerRequest.getNationalCode()));

        customerRepository.save(Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .nationalCode(customerRequest.getNationalCode())
                .build());
    }

    public String generateCIF(String nationalCode) {
        Random rand = new Random();
        int min = 10000;
        int max = 99999;
        int random = rand.nextInt((max - min) + 1) + min;
        String part1 = nationalCode.substring(0, 6);
        String part2 = Integer.toString(random);
        return part1 + part2;
    }

}
