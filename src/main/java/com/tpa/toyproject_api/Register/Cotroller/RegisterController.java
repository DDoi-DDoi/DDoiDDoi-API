package com.tpa.toyproject_api.Register.Cotroller;

import com.tpa.toyproject_api.Login.Entity.Member;
import com.tpa.toyproject_api.Register.DTO.MemberDTO;
import com.tpa.toyproject_api.Register.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final MemberRepository memberRepository;

    @Autowired
    public RegisterController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/register")
    public String registerMember(@RequestBody MemberDTO memberDTO) {
        Member member = new Member();
        member.setUserName(memberDTO.getUserName());
        member.setPassword(memberDTO.getPassword());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());

        memberRepository.save(member);
        System.out.println(member.toString());
        return "회원가입이 성공적으로 완료되었습니다!";
    }
}
