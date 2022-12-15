package com.banksystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private int destinationDepositNumber;
    private int originalDepositNumber;
    private int transactionAmount;
    private String transactionDate;
    private boolean transactionStatus;
    private String transactionDescription;

}
