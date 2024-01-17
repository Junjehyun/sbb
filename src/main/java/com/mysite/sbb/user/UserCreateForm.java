package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
// 회원 가입을 위한 폼 클래스.
@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25) // 데이터의 길이가 3~25 사이여야 한다는 검증 조건을 설정
    @NotEmpty(message = "사용자 ID는 필수항목입니다.")
    private String username;

    // 비밀번호
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;
    // 비밀번호 확인에 대한 속성 -> 왜 회원가입할때 비번 확인 두번 하지 않냐.
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;
}
