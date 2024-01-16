package com.mysite.sbb.question;
//서비스는 컨트롤러와 리포지터리의 중간에서 엔티티 객체와
// DTO 객체를 서로 변환하여 양방향에 전달하는 역할을 한다.
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.sbb.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // 레파지토리 객체가 어노테이션에 의해 생성자 방식으로 주입된다.
@Service // 서비스라는걸 선포함.
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
    // 제목과 내용을 입력받아 이를 질문으로 저장하는 create 메서드.
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
