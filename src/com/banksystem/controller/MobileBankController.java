package com.banksystem.controller;

import com.banksystem.model.request.SimCardchargeRequest;
import com.banksystem.service.Implement.MobileBankServiceImpl;
import com.banksystem.service.MobileBankService;

public class MobileBankController {

    MobileBankServiceImpl mobileBankServiceImpl = new MobileBankServiceImpl();
    public void buyCharge(SimCardchargeRequest simCardchargeRequest){
        mobileBankServiceImpl.buyCharge(simCardchargeRequest);

    }

}
