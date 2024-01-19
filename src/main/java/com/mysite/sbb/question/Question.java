package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter //롬복
@Setter //롬복
@Entity // 이걸 붙여줘야 엔티티로 인식 (엔티티란? 데이터베이스 테이블과 매핑되는 자바 클래스)
public class Question {
    // 기본키 지정 (중복되면 안되는 것들)
    @Id
    // 데이터를 저장할 때 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장됨.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //고유 번호

    @Column(length = 200)
    private String subject; // 제목

    @Column(columnDefinition = "TEXT")
    private String content; // 내용

    private LocalDateTime createDate; // 작성 일시

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    // 사용자 한 명이 질문을 여러 개 작성할 수 있기 때문에 ManyToOne
    @ManyToOne
    private SiteUser author;

    // 질문이 언제 수정 되었는가?
    private LocalDateTime modifyDate;
}
