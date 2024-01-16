package com.mysite.sbb.question;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class QuestionForm {
    //NotEmpty -> null이나 ""빈 문자열 허용X
    @NotEmpty(message = "제목은 필수항목입니다.")
    // 최대 길이가 200바이트 초과하면 X
    @Size(max=200)
    private String subject;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

}
