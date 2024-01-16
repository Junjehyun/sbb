package com.mysite.sbb.question;

import com.mysite.sbb.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// 생성한 QuestionRepository 인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속한다.
// JpaRepository는 JPA가 제공하는 인터페이스 중 하나로 CRUD 작업을 처리하는 메서드들을 이미 내장하고 있어
// 데이터 관리 작업을 좀 더 편리하게 처리할 수 있다.
// JpaRepository<Question, Integer>는 Question 엔티티로 리포지터리를 생성한다는 의미이다.
// Question 엔티티의 기본키가 Integer 임을 이와 같이 추가로 지정해야 한다.
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // findBySubject 메서드를 이렇게 넣어줘야 한다.
    Question findBySubject(String subject);

    // SQL에서 and 연산자를 활용해 여러 조건을 결합해 데이터를 조회한다.
    // subject와 content를 함께 조회 해보자!!
    Question findBySubjectAndContent(String subject, String content);

    // SQL에서는 특정 문자열을 포함한 데이터를 열에서 찾을 때 Like를 사용한다.
    // 응답 결과가 여러 건인 경우에는 메서드의 리턴 타입을 Question이 아닌 List<Question>으로 작성해야 함.
    List<Question> findBySubjectLike(String subject);

}
