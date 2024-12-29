package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.Account.AccountBalaceResponseDto;
import com.camp.campbankapp.dto.Account.AccountRequestDto;
import com.camp.campbankapp.dto.Account.AccountResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/** @Controller와 @ResponseBody를 결합한 애너테이션, 각 메서드가 JSON 형태의 데이터를 클라이언트에 반환할 수 있도록 설정
 * 데이터를 반환하는 RESTful API 개발 시 사용
 */
@RestController

@RequestMapping("/api/accounts")
// 클래스나 메서드에 공통된 URL 경로를 매핑하기 위해 사용,
// "/api/accounts" 경로로 들어오는 요청을 이 컨트롤러에서 처리 하도록 설정
public class AccountController {

    // 계좌 생성
    @PostMapping
    /**
     * @PostMapping : HTTP Post Method에 해당하는 단축 표현으로, 주로 리소스를 서버에 생성하거나 저장할 때 사용
     * ResponseEntity : HTTP Response 상태 코드와 데이터를 함께 설정 및 반환 가능
     * @RequestBody : 요청의 JSON 데이터를 메서드의 매개변수로 변환하여 바인딩
     * AccountResponseDto accountRequestDto : 요청 데이터를 담는 객체, 요청 데이터를 전달 받음
     * ResponseEntity<AccountResponseDto> : 응답 본문에 AccountResponseDto 객체를 담아 반환
     * */
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
        // 상태코드 CREATED(201)와 응답데이터(customerResponseDto)를 JSON형식으로 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponseDto);
    }


    // 계좌 조회
    /**
     * @GetMapping("/{accountId}") : HTTP GET 메서드를 처리하며, "/{accountId}" 경로를 통해 특정 고객 ID를 조회할 수 있도록 매핑
     * @PathVariable : URL 경로의 변수 값을 메서드 매개변수로 바인딩
     * ResponseEntity<AccountResponseDto> : 응답 본문에 AccountResponseDto 객체를 담아 반환
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> searchAccount(@PathVariable Long accountId){

        // AccountResponseDto 객체를 아래의 값들을 입력한 후 새로 생성한다
        AccountResponseDto accountResponseDto = new AccountResponseDto(
                accountId,
                1,
                "SAVINGS",
                1000.0

        );

        // 상태코드 OK로 반환, 값을 입력한 customerResponseDto 객체를 JSON 형식으로 BODY에 출력
        return ResponseEntity.status(HttpStatus.OK).body(accountResponseDto);
    }


    // 계좌 잔액 조회
    /**
     * @GetMapping("/{accountId}/balance") : HTTP GET 메서드를 처리하며, "/{accountId}/balance" 경로를 통해 특정 고객 ID를 조회할 수 있도록 매핑
     * @PathVariable : URL 경로의 변수 값을 메서드 매개변수로 바인딩
     * ResponseEntity<AccountBalaceResponseDto> : 응답 본문에 AccountBalaceResponseDto 객체를 담아 반환
     */
    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalaceResponseDto> searchBalanceAccount(@PathVariable Long accountId){

        // CustomerResponseDto 객체를 아래의 값들을 입력한 후 새로 생성한다
        AccountBalaceResponseDto accountBalaceResponseDto = new AccountBalaceResponseDto(
                accountId,
                1000.0
        );
        // 상태코드 OK(200)와 수정된 데이터(customerResponseDto) 객체를 JSON 형식으로 반환
        return ResponseEntity.status(HttpStatus.OK).body(accountBalaceResponseDto);
    }

    // 계좌 삭제
    /**
     * HTTP DELETE 메서드로, 서버에서 리소스를 삭제할 때 사용
     * URL 경로에 "/{accountId}"를 포함하여 특정 고객을 삭제하도록 매핑
     * */
    @DeleteMapping("/{accountId}")

    /**
     * @PathVariable : URL 경로에 포함된 변수(accountId)를 메서드의 매개변수로 바인딩
     * ResponseEntity<String> : 응답 본문으로 String 형식으로 반환
     * */
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId){
        // 상태코드 OK(200)과 삭제 성공 메세지("삭제 정상적으로 완료되었습니다")를 반환
        return ResponseEntity.status(HttpStatus.OK).body("삭제가 정상적으로 완료되었습니다.");
    }
}
