package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.Customer.CustomerRequestDto;
import com.camp.campbankapp.dto.Customer.CustomerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // @Controller와 @ResponseBody를 결합한 애너테이션, 각 메서드가 JSON 형태의 데이터를 Client에 반환할 수 있도록 설정
@RequestMapping(("/api/customers")) // 클래스 혹은 메서드에 URL 경로를 공통으로 매핑하기 위해 사용되는 애너테이션, "/api/customers" 경로로 들어오는 모든 요청이 이 컨트롤러에서 처리됨
public class CustomerController {

    // 고객 등록
    @PostMapping //
    /**
     * @PostMapping :
     * public CustomerResponseDto createCustomers() : Request(요청)값을 가져온다.
     * @RequestBody : API에 JSON 형식으로 되어있으니, 요청 JSON을 그대로 받아올려면 RequestBody를 사용해야한다.
     * ResponseEntity<CustomerResponseDto> :
     * */
    public ResponseEntity<CustomerResponseDto> createCustomers(@RequestBody CustomerRequestDto customerRequestDto){
        // 요청 처리 로직
        // Controller 테스트 단계 임으로 API 명세서 (API.md)에서 요구한 Response 데이터를 반환
        // id는 임시로 값 지정, 그 외의 요청 데이터는 response(응답) Dto에 직접적으로 값 넣어줌
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                1L,
                customerRequestDto.getName(),
                customerRequestDto.getEmail(),
                customerRequestDto.getPhone(),
                customerRequestDto.getAddress()
        );
        // ResponseEntity
        // 상태코드 CREATED로 반환, body를 응답받은 응답데이터 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
    }

    // 고객 조회
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> searchCustomers(@PathVariable Long customerId){
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customerId,
                "Robbie", // 임시 이름
                "Robbie@example.com", // 임시 이메일
                "010-1234-5678", // 임시 전화번호
                "123 Seoul"// 임시 주소
        );

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }


    // 고객 정보 수정
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> updateCustomers(@PathVariable Long customerId){
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customerId,
                "하진이",
                "wlsdl7520@naver.com",
                "010-1234-5678",
                "Daegu"
        );

        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }


     // 고객 삭제
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomers(@PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }

}
