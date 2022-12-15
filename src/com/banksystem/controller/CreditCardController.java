package com.banksystem.controller;

import com.banksystem.service.CreditCardService;
import com.banksystem.service.Implement.CreditCardServiceImpl;

import java.sql.SQLException;

public class CreditCardController {
    CreditCardServiceImpl creditCardService = new CreditCardServiceImpl();

    public CreditCardController() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

    }

    public void findCreditCard(){


    }

    public void createCreditCard(String accountNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        creditCardService.createCreditCard(accountNumber);


    }

}
