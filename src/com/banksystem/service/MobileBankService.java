package com.banksystem.service;

import com.banksystem.model.request.SimCardchargeRequest;

public interface MobileBankService {
    void buyCharge(SimCardchargeRequest simCardchargeRequest);
    void trancferCash();

    Long showBalance();
}
