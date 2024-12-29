package com.camp.campbankapp.dto.Customer;

import lombok.Getter;


// 객체의 캡슐화를 유지하면서, 클래스 외부에서 객체의 필드 값에 접근하거나 수정할 수 있도록 하기위해 사용
// @Getter 사용 시, get메서드 자동생성
@Getter
public class CustomerRequestDto {

    private String name; // 이름

    private String email; // 이메일

    private String phone; // 폰번호

    private String address; // 주소

    // 객체를 생성할 때 외부에서 받은 값을 필드에 넣는 역할을 한다.
    // 객체를 만들 때 필요한 값들을 한 번에 받아서, 올바르게 초기화하기 위해 사용됨
    public CustomerRequestDto(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
