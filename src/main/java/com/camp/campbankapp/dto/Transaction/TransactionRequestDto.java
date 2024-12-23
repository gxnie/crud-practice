package com.camp.campbankapp.dto.Transaction;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TransactionRequestDto {

    private Integer customerId;

    private String startDate;

    private String endDate;

    public TransactionRequestDto(Integer customerId, String startDate, String endDate) {
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
