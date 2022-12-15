package com.banksystem.view;

import com.banksystem.controller.AccountController;
import com.banksystem.controller.CustomerController;
import com.banksystem.model.Account;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {
    Scanner scn = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    AccountController accountController = new AccountController();

    public AccountView() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public void view() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        boolean quite = false;
        do {
        System.out.println("choose a number");
        System.out.println("1_create new account");
        System.out.println("2_find account");
        System.out.println("3_view all account");
        System.out.println("4- exit");

        int menuNumber = scn.nextInt();
        switch (menuNumber){
            case 1:
                createAccount();
                break;
            case 2:
                findAccount();
                break;
            case 3:
                viewCustomerAccounts();
                break;
            case 4:
                quite = true;
                MenuView.showMenu();
                break;
        }
        } while (!quite);

    }

    private void createAccount() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Enter your nationalID : ");
        String nationalID = scn.next();


        var customer = customerController.findCustomer(nationalID);
        var customerID = customer.getId();
        System.out.println("_____________________________________");
        if (customerID > 0){
            accountController.createAccount(customerID, nationalID);
        }else{
            System.out.println("there is no customer");
            var customerView = new CustomerView();
            customerView.createNewCustomer();
        }



    }

    private void findAccount(){
        System.out.println("Enter your account number:");
        String accountNumber = scn.next();


    }

    private void viewCustomerAccounts() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Enter your nationalcode:");
        String nationalCode = scn.next();
        var customerId = customerController.findCustomer(nationalCode).getId();
        var accounts = accountController.viewCustomerAccounts(customerId);

        accounts.forEach( account ->
                System.out.println(account.getAccountNumber()));

    }
}
