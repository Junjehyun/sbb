package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // question 엔티티와는 달리 answer엔티티에서는 question을 참조하기 위해 question 속성을 추가함.
    // 답변을 해야되니까
    @ManyToOne
    // 게시판 서비스에서는 하나의 질문에 답변은 여러 개가 달릴 수 있다. 따라서 답변은 Many(많은 것)가 되고 질문은 One(하나)이 된다.
    // 즉, @ManyToOne 애너테이션을 사용하면 N:1 관계를 나타낼 수 있다.
    // 이렇게 @ManyToOne 애너테이션을 설정하면 Answer(답변) 엔티티의 question 속성과 Question(질문) 엔티티가 서로 연결된다
    // (실제 데이터베이스에서는 외래키(foreign key) 관계가 생성된다.).
    private Question question;

    // @ManyToOne은 부모 자식 관계를 갖는 구조에서 사용한다. 여기서 부모는 Question, 자식은 Answer라고 할 수 있다.
    // 외래키란 테이블과 테이블 사이의 관계를 구성할 때 연결되는 열을 의미한다.

    @ManyToOne
    private SiteUser author;
}

