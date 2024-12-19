package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.Transaction.TransactionRequestDto;
import com.camp.campbankapp.dto.Transaction.TransactionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    // 거래 내역 조회
    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> searchTransaction(TransactionRequestDto requestDto){
        List<TransactionResponseDto> transaction = new ArrayList<>();
        transaction.add(new TransactionResponseDto(1001L,101,"DEPOSIT",500.0,"2024-01-15T10:00:00"));
        transaction.add(new TransactionResponseDto(1002L,101,"WITHDRAWAL",200.0,"2024-01-20T14:30:00"));
        return ResponseEntity.status(HttpStatus.OK).body(transaction);
    }

    // 거래 생성
    @PostMapping
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionRequestDto requestDto){
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(
                1003L,
                101,
                "DEPOSIT",
                1000.0,
                "2024-02-01T11:00:00"
        );
        return ResponseEntity.status(HttpStatus.OK).body(transactionResponseDto);
    }


    // 특정 거래 조회
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponseDto> findTransaction(@PathVariable Long transactionId){
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(
                transactionId,
                101,
                "DEPOSIT",
                500.0,
                "2024-01-15T10:00:00"
        );
        return ResponseEntity.status(HttpStatus.OK).body(transactionResponseDto);
    }
}
