package com.mysite.sbb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 데이터베이스에서 특정 엔티티 또는 데이터를 찾을 수 없을 때 발생시키는 예외클래스.
// 이 예외가 발생하면 스프링부트는 설정된 HTTP 상태코드와 이유를 포함한 응답을 생성하여
// 클라이언트에게 반환하게 된다. 여기서는 404오류를 반환하게 작성함.
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
// RuntimeException을 상속하는 것은 사용자 정의 예외 클래슬르 정의하는 방법중 하나
// RuntimeException은 실행 시 발생하는 예외라는 의미이다.
public class DataNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public DataNotFoundException(String message) {
        super(message);
    }
}
