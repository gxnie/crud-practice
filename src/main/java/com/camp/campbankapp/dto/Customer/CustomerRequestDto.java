package com.camp.campbankapp.dto.Customer;

import lombok.Getter;

@Getter //
public class CustomerRequestDto {

    private String name;

    private String email;

    private String phone;

    private String address;

    public CustomerRequestDto(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
