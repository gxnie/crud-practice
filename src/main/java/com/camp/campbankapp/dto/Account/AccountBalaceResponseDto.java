package com.camp.campbankapp.dto.Account;


import lombok.Getter;

@Getter
public class AccountBalaceResponseDto {

    private Long accountId;

    private Double balance;

    public AccountBalaceResponseDto(Long accountId, Double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}

