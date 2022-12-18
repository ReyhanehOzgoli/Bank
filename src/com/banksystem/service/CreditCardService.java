package com.banksystem.service;

import com.banksystem.model.CreditCard;

import java.sql.SQLException;

public interface CreditCardService {
    void createCreditCard(String accountNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
     CreditCard findCreditCard();
     String findAccountWithCardNumber(String cardNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}

