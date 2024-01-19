package com.mysite.sbb.user;

import lombok.Getter;

@Getter
public enum UserRole {
    // 상수로 관리자와 유저를 만듬.
    // 상수값은 변경할 필요가 없으므로 Setter없이 Getter만..
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}


// 스프링 시큐리티는 사용자 인증 후에 사용자에게 부여할 권한과 관련된 내용이 필요하다.
// 사용자가 로그인 한 후, admin또는 user와 같은 권한을 부여해야한다.