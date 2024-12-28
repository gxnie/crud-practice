package com.camp.campbankapp.dto.Customer;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

// 객체의 캡슐화를 유지하면서, 클래스 외부에서 객체의 필드 값에 접근하거나 수정할 수 있도록 하기위해 사용
// @Getter 사용 시, get메서드 자동생성
@Getter
public class CustomerResponseDto {

    @Id // 데이터베이스의 Primary Key임을 나타낸다
    /**
     * GenerationType : 자동 증가 방식을 설정하는 옵션
     * GenerationType.AUTO : 데이터베이스의 Auto Increment 기능을 사용, JPA가 데이터베이스에 맞는 방식을 자동으로 선택
     * */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id값

    private final String name; // 이름

    private final String email; // 이메일

    private final String phone; // 폰번호

    private final String address; // 주소

    // 객체를 생성할 때 외부에서 받은 값을 필드에 넣는 역할을 한다.
    // 객체를 만들 때 필요한 값들을 한 번에 받아서, 올바르게 초기화하기 위해 사용됨
    public CustomerResponseDto(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
