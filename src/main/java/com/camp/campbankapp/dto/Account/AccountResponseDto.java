package com.camp.campbankapp.dto.Account;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountResponseDto {

    private Long accountId;

    private Integer customerId;

    private String accountType;

    private Double balance;

    public AccountResponseDto(Long accountId, Integer customerId, String accountType, Double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }


}
