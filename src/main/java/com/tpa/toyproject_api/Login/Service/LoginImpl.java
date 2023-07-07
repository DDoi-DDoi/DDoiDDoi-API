/*package com.tpa.toyproject_api.Login.Service;

import com.tpa.toyproject_api.Login.Dto.MemberDto;
import com.tpa.toyproject_api.Login.Entity.Member;
import com.tpa.toyproject_api.Login.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl{
    public LoginRepository loginRepository;
    @Autowired
    public LoginImpl(LoginRepository logninRepository)
    {
        this.loginRepository = loginRepository;
    }
    public void Signup(MemberDto memberDto)
    {
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setName(memberDto.getName());
        member.setPassword(memberDto.getPassword());
        loginRepository.save(member);
    }
    public void SignIn(MemberDto memberDto)
    {

    }
    public boolean checkID(MemberDto memberDto)
    {
        Member findMember  = loginRepository.findByIdAndPassword(memberDto.getId(), memberDto.getPassword());

        if(findMember==null)
        {
            return false;
        }
        return true;
    }

}*/