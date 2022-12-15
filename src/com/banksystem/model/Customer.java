package com.banksystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class Customer {

    public Customer(){
    }


    private String lastName;
    private String firstName;
    private String nationalCode;
    private int id;
    private String fullName;


}

