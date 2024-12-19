package com.camp.campbankapp.dto.Transaction;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TransactionResponseDto {

    private Long transactionId;

    private Integer accountId;

    private String transactionType;

    private Double amount;

    private String transactionDate;

    public TransactionResponseDto(Long transactionId, Integer accountId,
                                  String transactionType, Double amount, String transactionDate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }
}
