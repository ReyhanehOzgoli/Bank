package com.banksystem.model.request;

import com.banksystem.enumeration.Operator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimCardchargeRequest {
    private String phoneNumber;
    private Operator Operator;
    private Long amount;
    private String cardNumber;

}
