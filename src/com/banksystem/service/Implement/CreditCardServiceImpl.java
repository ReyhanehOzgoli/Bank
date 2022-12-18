package com.banksystem.service.Implement;

import com.banksystem.model.CreditCard;
import com.banksystem.repository.CreditCardRepository;
import com.banksystem.service.CreditCardService;

import java.sql.SQLException;

public class CreditCardServiceImpl implements CreditCardService {

    AccountServiceImpl accountService = new AccountServiceImpl();
    CreditCardRepository creditCardRepository = new CreditCardRepository();

    public CreditCardServiceImpl() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void createCreditCard(String accountNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        var accountID = accountService.findAccount(accountNumber).getId();

        var creditCardNumber = generateCreditCardNumber();
        var CVV2 = generateCVV2();
        var creditCard = CreditCard.builder()
                        .cardNumber(creditCardNumber)
                        .CVV2(CVV2)
                        .accountID(accountID)
                        .build();

            creditCardRepository.save(creditCard);

    }

    private int generateCVV2(){
        int min = 1000;
        long max = 9999;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;

    }
    private String generateCreditCardNumber() {
        String part1 = "62198610";
        int min = 1000000;
        long max = 99999999;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        String cardNumber = part1.concat(String.valueOf(random_int));
        return cardNumber;
    }


    @Override
    public CreditCard findCreditCard() {
        return null;

    }

    @Override
    public String findAccountWithCardNumber(String cardNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return creditCardRepository.findAccountNumber(cardNumber);


    }
}
