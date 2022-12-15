package com.banksystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class Account {
    private int id;
    private int customerID;
    private String accountNumber;
    private String shebaNumber;
    private long cashBalance;
    private StatusAccount status;

    public enum StatusAccount {
        open, close
    }


}
