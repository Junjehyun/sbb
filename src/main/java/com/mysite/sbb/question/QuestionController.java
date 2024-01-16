package com.mysite.sbb.question;

import com.mysite.sbb.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// @RequiredArgsConstructor -> 롬복(Lombok)이 제공하는 애너테이션으로,
// final이 붙은 속성을 포함하는 생성자를 자동으로 만들어 주는 역할을 한다.
@RequiredArgsConstructor // 생성자 방식으로 questionRepository 객체를 주입
@Controller
// QuestionController에 속하는 URL매핑은 항상 /question 프리픽스(접두사)로 시작할 수 있도록 설정.
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    // 매개변수로 Model을 지정하면 객체가 자동으로 생성된다.
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    // 변하는 id값을 얻을 때는 @PathVariable을 사용한다.
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    // 질문등록하기 버튼 눌리면 질문 등록 페이지로 이동 됨.
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}
//컨트롤러 → 서비스 → 리포지터리 순서로 접근
//2-16 질문 등록 기능 추가하기부터