package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // 컨트롤러임을 선언.
public class MainController {
    @GetMapping("/sbb") //url 매핑을 담당
    @ResponseBody // 문자열을 리턴하라는 의미, 이걸 생략하면 index라는 문자열 대신 index라는 이름의 템플릿을 찾게됨.
    public String index() {
        return "안녕하세요 sbb에 오신 것을 환영합니다.";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
