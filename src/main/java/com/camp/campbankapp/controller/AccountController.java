package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.Account.AccountBalaceResponseDto;
import com.camp.campbankapp.dto.Account.AccountRequestDto;
import com.camp.campbankapp.dto.Account.AccountResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    // 계좌 생성
    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody AccountRequestDto accountRequestDto){
        // 요청 처리 로직
        // Controller 테스트 단계 임으로 API 명세서 (API.md)에서 요구한 Response 데이터를 반환
        // id는 임시로 값 지정, 그 외의 요청 데이터는 response(응답) Dto에 직접적으로 값 넣어줌
        AccountResponseDto accountResponseDto = new AccountResponseDto(
                101L,
                accountRequestDto.getCustomerId(),
                accountRequestDto.getAccountType(),
                accountRequestDto.getInitialDeposit()
        );
        // ResponseEntity
        // 상태코드 CREATED로 반환, body를 응답받은 응답데이터 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponseDto);
    }


    // 계좌 조회
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> searchAccount(@PathVariable Long accountId){
        AccountResponseDto accountResponseDto = new AccountResponseDto(
                accountId,
                1,
                "SAVINGS",
                1000.0

        );
        return ResponseEntity.status(HttpStatus.OK).body(accountResponseDto);
    }


    // 계좌 잔액 조회
    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalaceResponseDto> searchBalanceAccount(@PathVariable Long accountId){
        AccountBalaceResponseDto accountBalaceResponseDto = new AccountBalaceResponseDto(
                accountId,
                1000.0
        );
        return ResponseEntity.status(HttpStatus.OK).body(accountBalaceResponseDto);
    }

    // 계좌 삭제
    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId){
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}
