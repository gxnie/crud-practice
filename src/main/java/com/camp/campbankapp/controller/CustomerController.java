package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.Customer.CustomerRequestDto;
import com.camp.campbankapp.dto.Customer.CustomerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** @Controller와 @ResponseBody를 결합한 애너테이션, 각 메서드가 JSON 형태의 데이터를 클라이언트에 반환할 수 있도록 설정
 * 데이터를 반환하는 RESTful API 개발 시 사용
*/
@RestController

@RequestMapping(("/api/customers"))
// 클래스나 메서드에 공통된 URL 경로를 매핑하기 위해 사용,
// "/api/customers" 경로로 들어오는 요청을 이 컨트롤러에서 처리 하도록 설정
public class CustomerController {

    // 고객 등록
    @PostMapping
    /**
     * @PostMapping : HTTP Post Method에 해당하는 단축 표현으로, 주로 리소스를 서버에 생성하거나 저장할 때 사용
     * ResponseEntity : HTTP Response 상태 코드와 데이터를 함께 설정 및 반환 가능
     * @RequestBody : 요청의 JSON 데이터를 메서드의 매개변수로 변환하여 바인딩
     * CustomerRequestDto customerRequestDto : 요청 데이터를 담는 객체, 요청 데이터를 전달 받음
     * ResponseEntity<CustomerResponseDto> : 응답 본문에 CustomerResponseDto 객체를 담아 반환
     * */
    public ResponseEntity<CustomerResponseDto> createCustomers(@RequestBody CustomerRequestDto customerRequestDto){
        // 요청 처리 로직
        // 현재 단계는 Controller 테스트를 위한 단계이므로, API 명세서(API.md)에 정의된 형식으로 응답 데이터를 반환
        // id는 실제 데이터베이스 연동이 없으므로 임시로 1L을 지정하고,
        // 나머지 필드는 요청(Request) DTO에서 전달받은 데이터를 사용
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                1L, // id
                customerRequestDto.getName(), // 요청 Dto에서 이름을 가져온다
                customerRequestDto.getEmail(), // 요청 Dto에서 이메일을 가져온다
                customerRequestDto.getPhone(), // 요청 Dto에서 폰번호를 가져온다
                customerRequestDto.getAddress() // 요청 Dto에서 주소를 가져온다
        );
        // 상태코드 CREATED(201)와 응답데이터(customerResponseDto)를 JSON형식으로 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
    }

    // 고객 조회
    /**
     * @GetMapping("/{customerId}") : HTTP GET 메서드를 처리하며, "/{customerId}" 경로를 통해 특정 고객 ID를 조회할 수 있도록 매핑
     * @PathVariable : URL 경로의 변수 값을 메서드 매개변수로 바인딩
     * ResponseEntity<CustomerResponseDto> : 응답 본문에 CustomerResponseDto 객체를 담아 반환
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> searchCustomers(@PathVariable Long customerId){

        // CustomerResponseDto 객체를 아래의 값들을 입력한 후 새로 생성한다
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customerId, // 고객 Id
                "Robbie", // 임시 이름
                "Robbie@example.com", // 임시 이메일
                "010-1234-5678", // 임시 전화번호
                "123 Seoul"// 임시 주소
        );

        // 상태코드 OK로 반환, 값을 입력한 customerResponseDto 객체를 JSON 형식으로 BODY에 출력
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }


    // 고객 정보 수정
    /**
     * HTTP Put Method에 해당, 서버에 리소스를 전체 수정할 때 사용
     * URL에 /{customerId} 를 입력하면, 특정 고객의 정보를 수정하도록 맵핑 되어있음
     * */
    @PutMapping("/{customerId}")

    /**
     * @PathVariable : URL 경로에 포함된 변수(customerId)를 메서드의 매개변수로 바인딩
     * ResponseEntity<CustomerResponseDto> : 수정된 고객 정보를 응답 본문으로 반환
     */
    public ResponseEntity<CustomerResponseDto> updateCustomers(@PathVariable Long customerId){

        // 수정 값을 응답 받을, 응답 데이터 객체 생성
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                customerId,
                "하진이", // 수정할 이름
                "wlsdl7520@naver.com", // 수정할 이메일
                "010-1234-5678", // 수정할 전화번호
                "Daegu" // 수정할 주소
        );
        // 상태코드 OK(200)와 수정된 데이터(customerResponseDto) 객체를 JSON 형식으로 반환
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseDto);
    }

    // 고객 삭제
    /**
     * HTTP DELETE 메서드로, 서버에서 리소스를 삭제할 때 사용
     * URL 경로에 "/{customerId}"를 포함하여 특정 고객을 삭제하도록 매핑
     * */
    @DeleteMapping("/{customerId}")

    /**
     * @PathVariable : URL 경로에 포함된 변수(customerId)를 메서드의 매개변수로 바인딩
     * ResponseEntity<String> : 응답 본문으로 String 형식으로 반환
     * */
    public ResponseEntity<String> deleteCustomers(@PathVariable Long customerId){
        // 상태코드 OK(200)과 삭제 성공 메세지("삭제 되었습니다")를 반ㅎ환
        return ResponseEntity.status(HttpStatus.OK).body("삭제 되었습니다");
    }

}
