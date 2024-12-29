package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.Transaction.TransactionRequestDto;
import com.camp.campbankapp.dto.Transaction.TransactionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/** @Controller와 @ResponseBody를 결합한 애너테이션, 각 메서드가 JSON 형태의 데이터를 클라이언트에 반환할 수 있도록 설정
 * 데이터를 반환하는 RESTful API 개발 시 사용
 */
@RestController
@RequestMapping("/api/transactions")
// 클래스나 메서드에 공통된 URL 경로를 매핑하기 위해 사용,
// "/api/transactions" 경로로 들어오는 요청을 이 컨트롤러에서 처리 하도록 설정
public class TransactionController {

    // 거래 내역 조회
    // @GetMapping : HTTP GET 메서드를 처리하며, 일반적인 요청 전체를 조회
    @GetMapping
    // ResponseEntity : HTTP Response 상태 코드와 데이터를 함께 설정 및 반환 가능
    public ResponseEntity<List<TransactionResponseDto>> getTransaction(@ModelAttribute TransactionRequestDto requestDto){
        // 요청 데이터를 바탕으로 거래 내역(List<TransactionResponseDto>)을 응답으로 반환

        // @ModelAttribute : HTTP 요청의 파라미터를 TransactionRequestDto 객체에 자동으로 매핑
        // - 요청 URL의 쿼리 파라미터를 기반으로 TransactionRequestDto 객체가 생성
        // - 예) 요청 URL: /transactions?customerId=101&transactionType=DEPOSIT
        //      -> requestDto.customerId = 101
        //      -> requestDto.transactionType = "DEPOSIT"

        // 여러개의 거래들을 저장하기 위해 List 사용해서, 객체 생성
        List<TransactionResponseDto> transaction = new ArrayList<>();

        // 응답 데이터를 TransactionResponseDto 객체에 담아 새로 생성 후 transaction 리스트에 추가
        transaction.add(new TransactionResponseDto(1001L,101,"DEPOSIT",500.0,"2024-01-15T10:00:00"));
        transaction.add(new TransactionResponseDto(1002L,101,"WITHDRAWAL",200.0,"2024-01-20T14:30:00"));

        // 새로운 응답코드 OK(200)을 반환
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    // 거래 생성
    @PostMapping
    /**
     * @PostMapping : HTTP Post Method에 해당하는 단축 표현으로, 주로 리소스를 서버에 생성하거나 저장할 때 사용
     * ResponseEntity : HTTP Response 상태 코드와 데이터를 함께 설정 및 반환 가능
     * @RequestBody : 요청의 JSON 데이터를 메서드의 매개변수로 변환하여 바인딩
     * TransactionResponseDto transactionResponseDto : 요청 데이터를 담는 객체, 요청 데이터를 전달 받음
     * ResponseEntity<TransactionResponseDto> : 응답 본문에 transactionResponseDto 객체를 담아 반환
     * */
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionRequestDto requestDto){
        // 요청 처리 로직
        // 현재 단계는 Controller 테스트를 위한 단계이므로, API 명세서(API.md)에 정의된 형식으로 응답 데이터를 반환
        // id는 실제 데이터베이스 연동이 없으므로 임시로 데이터를 지정하고,
        // 나머지 필드는 요청(Request) DTO에서 전달받은 데이터를 사용
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(
                // 임시로 값을 넣어줌
                1003L,
                101,
                "DEPOSIT",
                1000.0,
                "2024-02-01T11:00:00"
        );
        // 상태코드 OK(200)와 응답데이터(TransactionResponseDto)를 JSON형식으로 반환
        return ResponseEntity.status(HttpStatus.OK).body(transactionResponseDto);
    }


    // 특정 거래 조회
    /**
     * @GetMapping("/{transactionId}") : HTTP GET 메서드를 처리하며, "/{transactionId}" 경로를 통해 특정 고객 ID를 조회할 수 있도록 매핑
     * @PathVariable : URL 경로의 변수 값을 메서드 매개변수로 바인딩
     * ResponseEntity<TransactionResponseDto> : 응답 본문에 TransactionResponseDto 객체를 담아 반환
     */
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponseDto> findTransaction(@PathVariable Long transactionId){
        // 요청 처리 로직
        // 현재 단계는 Controller 테스트를 위한 단계이므로, API 명세서(API.md)에 정의된 형식으로 응답 데이터를 반환
        // id는 실제 데이터베이스 연동이 없으므로 임시로 데이터를 지정하고,
        // 나머지 필드는 요청(Request) DTO에서 전달받은 데이터를 사용
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(
                transactionId,
                101,
                "DEPOSIT",
                500.0,
                "2024-01-15T10:00:00"
        );
        // 상태코드 OK(200)와 응답데이터(TransactionResponseDto)를 JSON형식으로 반환
        return ResponseEntity.status(HttpStatus.OK).body(transactionResponseDto);
    }
}
