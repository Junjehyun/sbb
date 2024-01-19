package com.mysite.sbb.question;
//서비스는 컨트롤러와 리포지터리의 중간에서 엔티티 객체와
// DTO 객체를 서로 변환하여 양방향에 전달하는 역할을 한다.
import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mysite.sbb.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public void create(String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.asc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }
    // 수정된 질문이 서비스를 통해 처리될 수 있도록 modify 메서드를 추가해보자.
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    // 질문 데이터를 삭제하는 delete 메서드 추가
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
