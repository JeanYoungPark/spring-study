package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //연결 시켜준다. 의존관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
