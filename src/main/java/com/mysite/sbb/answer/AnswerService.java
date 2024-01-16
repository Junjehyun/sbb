package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    // 답변을 생성하기 위해 create 메서드를 추가.
    // create 메서드는 입력받은 2개의 매개변수인 question과 content를 사용해 Answer객체를
    // 생성하여 저장.
    public void create(Question question, String content) {
        Answer answer = new Answer();

        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);

    }
}
