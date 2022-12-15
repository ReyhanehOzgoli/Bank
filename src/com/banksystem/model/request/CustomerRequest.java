package com.banksystem.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    private String lastName;
    private String firstName;
    private String nationalCode;
}
