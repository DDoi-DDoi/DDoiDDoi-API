package com.tpa.toyproject_api.Login.Controller;

import com.tpa.toyproject_api.Login.Dto.MemberDto;
import com.tpa.toyproject_api.Login.Service.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    @Autowired
    private LoginImpl signin;
    @PostMapping("/postMethod")
    public ResponseEntity<String> processData(
            @RequestBody MemberDto memberDto, @RequestHeader("Content-type") String contentType) { //body : 본문, header : 부가적인 정보 : Content - type(application/json)
        if ("application/json".equals(contentType)) {
            String result;
            boolean flag = signin.checkID(memberDto);
            if(flag) {
                result = "로그인 성공";
            } else
            {
                result = "로그인 실패";
            }
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body("Invalid Content-Type");
        }
    }
}
