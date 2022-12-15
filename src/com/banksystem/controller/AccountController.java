package com.banksystem.controller;

import com.banksystem.model.Account;
import com.banksystem.service.AccountService;
import com.banksystem.service.Implement.AccountServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    AccountServiceImpl accountService = new AccountServiceImpl();

    public AccountController() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    public void createAccount(int customerId, String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        accountService.createAccount( customerId,nationalCode);
    }
    public List<Account> viewCustomerAccounts(int customerId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return accountService.viewCustomerAccounts(customerId);

    }

}
