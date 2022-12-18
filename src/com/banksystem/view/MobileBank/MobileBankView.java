package com.banksystem.view.MobileBank;

import com.banksystem.controller.MobileBankController;
import com.banksystem.enumeration.Operator;
import com.banksystem.model.request.SimCardchargeRequest;

import java.util.Scanner;

public class MobileBankView {

    MobileBankController mobileBankController = new MobileBankController();
    Scanner scn = new Scanner(System.in);
    public void menuView(){

        System.out.println(" Welcome to Mobilebank");
        System.out.println("1_ buy a charge");
        System.out.println("2_ Transfer a Cash");
        System.out.println("3_ Show balance");
        System.out.println("4_ Exit");

        boolean quite = false;
        do{

            int menuNumber = scn.nextInt();
            switch(menuNumber) {
                case 1:
                    buyCharge();
                    break;
                case 2:
                    trancferCash();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    quite = true;
                    break;
                }


            }while(!quite);

    }

    private void showBalance() {
    }

    private void trancferCash() {
    }


    private void buyCharge() {
        SimCardchargeRequest simCardchargeRequest = new SimCardchargeRequest();

        System.out.println("Phone Number");
        String phoneNumber = scn.next();
        simCardchargeRequest.setPhoneNumber(phoneNumber);

        System.out.println("card Number");
        String cardNumber = scn.next();
        simCardchargeRequest.setCardNumber(cardNumber);

        System.out.println("Operator");
        var operator = useOperator();
        simCardchargeRequest.setOperator(operator);

        System.out.println("Amount");
        Long amount = scn.nextLong();
        simCardchargeRequest.setAmount(amount);

        mobileBankController.buyCharge(simCardchargeRequest);

    }
     public Operator useOperator(){
         System.out.println("Use your Operator");
         System.out.println("1_ Telekom");
         System.out.println("2_ Vodafone");
         System.out.println("3-Meo");

         Operator operator = null;

         int operatorNumber = scn.nextInt();
         switch (operatorNumber){
             case 1:
                 operator = Operator.Telekom;

             case 2:
                 operator = Operator.Vodafone;

             case 3:
                 operator = Operator.Meo;

         }
         return operator;
     }




}
