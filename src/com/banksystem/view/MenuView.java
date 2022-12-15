package com.banksystem.view;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class MenuView {
    public static void showMenu() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scn = new Scanner(System.in);

        boolean quite = false;
        do {
            System.out.println("you are welcome");
            System.out.println("choose a number");
            System.out.println("1_Customer");
            System.out.println("2_Bank account");
            System.out.println("3-CreditCard");
            System.out.println("4_exit");

            int menuNumber = scn.nextInt();

            switch (menuNumber) {
                case 1:
                    var customerView = new CustomerView();
                    customerView.view();
                    break;
                case 2:
                    var accountView = new AccountView();
                    accountView.view();
                    System.out.println("you create bank account");
                    break;
                case 3:
                    var creditCardView = new CreditCardView();
                    creditCardView.view();
                    System.out.println("you have a CreditCard");
                    break;
                case 4:
                    quite = true;
                    System.out.println("you are logging out");
                    break;
            }
        } while (!quite);

    }

}







