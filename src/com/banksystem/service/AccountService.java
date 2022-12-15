package com.banksystem.service;

import com.banksystem.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    void createAccount(int customerId, String nationalCode) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    List<Account> viewCustomerAccounts(int customerId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    Account findAccount(String accountNumber) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

}
