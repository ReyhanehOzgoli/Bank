package com.banksystem.service.Implement;

import com.banksystem.model.Account;
import com.banksystem.repository.AccountRepository;
import com.banksystem.service.AccountService;

import java.awt.*;
import java.sql.SQLException;
import java.util.Random;

public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository = new AccountRepository();

    public AccountServiceImpl() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void createAccount(int customerId, String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        var accountNumber = generateAccountNumber(nationalCode);

        accountRepository.save(Account.builder()
                .accountNumber(accountNumber)
                .shebaNumber("IR"+ accountNumber)
                .cashBalance(0)
                .status(Account.StatusAccount.open)
                .customerID(customerId).build());

    }

    public String generateAccountNumber(String nationalCode){
            Random rand = new Random();
            int min = 10000;
            int max = 99999;
            int random = rand.nextInt((max - min) + 1) + min;
            String part1 = nationalCode.substring(0, 6);
            String part2 = Integer.toString(random);
            return part1 + part2;

    }

    @Override
    public java.util.List<Account> viewCustomerAccounts(int customerId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return accountRepository.findCustomerAccounts(customerId);

    }

    @Override
    public Account findAccount(String accountNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return accountRepository.find(accountNumber);

    }
}
