package com.camp.campbankapp.dto.Account;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountRequestDto {


    private Integer customerId;

    private String accountType;

    private Double initialDeposit;


    public AccountRequestDto(Integer customerId, String accountType, Double initialDeposit) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
    }
}
