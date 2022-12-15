package com.banksystem.view;

import com.banksystem.controller.AccountController;
import com.banksystem.controller.CreditCardController;
import com.banksystem.controller.CustomerController;

import java.sql.SQLException;
import java.util.Scanner;
public class CreditCardView {
    CreditCardController creditCardController = new CreditCardController();
    Scanner scn = new Scanner(System.in);
    public CreditCardView() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    }

    public void view() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        boolean quite = false;
        do {
        System.out.println(" choose a Number ");
        System.out.println("1_create CreditCard");
        System.out.println("2_find CreditCard");
        System.out.println("3_exit");

        int num = scn.nextInt();
        switch (num){
            case 1:
                createCreditCard();
                System.out.println("you have a CreditCard");
                break;
            case 2:
                findCreditCard();
                System.out.println("your CreditCard");
                break;
            case 3:
                quite = true;
                MenuView.showMenu();
                break;
        }
    } while (!quite);
    }

    private void findCreditCard() {
    }

    private void createCreditCard() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        System.out.println("Enter your accountNumber");
        String accountNumber = scn.next();



        creditCardController.createCreditCard(accountNumber);

    }
}
