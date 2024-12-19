package com.camp.campbankapp.dto.Transaction;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TransactionRequestDto {

    private Integer customerId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public TransactionRequestDto(Integer customerId, LocalDateTime startDate, LocalDateTime endDate) {
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
