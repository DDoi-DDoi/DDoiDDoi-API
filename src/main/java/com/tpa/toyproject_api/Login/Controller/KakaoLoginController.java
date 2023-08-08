package com.tpa.toyproject_api.Login.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpa.toyproject_api.Login.Dto.KakaoProfile;
import com.tpa.toyproject_api.Login.OAuthToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
@CrossOrigin("http://localhost:3000")
public class KakaoLoginController {
    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code) throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        //HttpBody 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params =new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","9c1334c51e7f951b09babbdf6384f381");
        params.add("redirect_uri","http://localhost:8080/auth/kakao/callback");
        params.add("code",code);
        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params,headers);
        //Http 요청하기 - POST 방식
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = null;
        try {
            oAuthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
        }catch (JsonMappingException e){
            e.printStackTrace();;
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println("카카오 액세스 토큰 :" +  oAuthToken.getAccess_token());

        RestTemplate rt2 = new RestTemplate();
        //HttpBody 오브젝트 생성
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization","Bearer "+oAuthToken.getAccess_token());
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest = new HttpEntity<>(headers2);
        //Http 요청하기 - POST 방식
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
        }catch (JsonMappingException e){
            e.printStackTrace();;
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        System.out.println("카카오톡 아이디: "+kakaoProfile.id);
        System.out.println("카카오톡 이메일: "+kakaoProfile.kakao_account.email);
        return response2.getBody();
}
}
