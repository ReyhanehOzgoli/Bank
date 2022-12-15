package com.banksystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreditCard{
    private int id;
    private String cardNumber;
    private int CVV2;
    private int accountID;

}
