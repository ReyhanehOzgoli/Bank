package com.banksystem.view;

import com.banksystem.controller.CustomerController;
import com.banksystem.model.Customer;
import com.banksystem.model.request.CustomerRequest;
import com.banksystem.model.request.CustomerRequest;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerView {

    Scanner scn = new Scanner(System.in);
    CustomerController customerController = new CustomerController();

    public CustomerView() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public void view() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        boolean quite = false;
        do {
            System.out.println("choose a number");
            System.out.println("1- create new customer");
            System.out.println("2- find customer");
            System.out.println("3- show all customer");
            System.out.println("4- exit");


            int menuNumber = scn.nextInt();

            switch (menuNumber) {
                case 1:
                    createNewCustomer();
                    break;

                case 2:
                    findCustomer();
                    break;

                case 3:
                    showAllCustomer();
                    break;

                case 4:
                    quite = true;
                    MenuView.showMenu();
                    break;
            }
        } while (!quite);


    }

    private void showAllCustomer() throws SQLException {
        customerController.findAllCustomer();
    }

    private void findCustomer() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Please enter your NationalCode");
        String nationalCode = scn.next();
        customerController.findCustomer(nationalCode);

    }

    public void createNewCustomer() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CustomerRequest customerRequest = new CustomerRequest();

        System.out.println("Enter your firstname");
        customerRequest.setFirstName(scn.next());
        System.out.println("Enter your lastname");
        customerRequest.setLastName(scn.next());
        System.out.println("Enter your National Code");
        customerRequest.setNationalCode(scn.next());

        customerController.createCustomer(customerRequest);
    }

}
