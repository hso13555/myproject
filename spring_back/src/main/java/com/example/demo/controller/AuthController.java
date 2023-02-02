package com.example.demo.controller;

import com.example.demo.dto.MailDto;
import com.example.demo.dto.TokenDto;
import com.example.demo.dto.request.MemberReqDto;
import com.example.demo.dto.request.PwFinderRequestDto;
import com.example.demo.dto.response.MemberRespDto;
import com.example.demo.service.AuthService;
import com.example.demo.service.SendMailService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;
  private final SendMailService sendMailService;

  //회원가입
  @PostMapping("/signup")
  public ResponseEntity<MemberRespDto> signup(
    @RequestBody MemberReqDto requestDto
  ) {
    return ResponseEntity.ok(authService.signup(requestDto));
  }
  //로그인
  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(
    @RequestBody MemberReqDto requestDto
  ) {
    return ResponseEntity.ok(authService.login(requestDto));
  }

  //아이디 중복체크
  @GetMapping("/checkEmail/{email}")
  public ResponseEntity<Boolean> checkEmailDuplicate(
    @PathVariable String email
  ) {
    return ResponseEntity.ok(authService.checkEmail(email));
  }

  //비밀번호 찾기시
  @PostMapping("/checkEmail/findPw")
  public Map<String, Boolean> pw_find(@RequestBody PwFinderRequestDto dto) {
    Map<String, Boolean> json = new HashMap<>();
    boolean pwFindCheck = authService.checkEmailAndName(
      dto.getUserEmail(),
      dto.getUserName()
    );

    json.put("check", pwFindCheck);
    return json;
  }

  //등록된 이메일로 임시비밀번호를 발송하고 발송된 임시비밀번호로 사용자의 pw를 변경하는 컨트롤러
  @PostMapping("/check/findPw/sendEmail")
  public void sendEmail(@RequestBody PwFinderRequestDto requestDto) {
    log.info("test" + requestDto);
    MailDto dto = sendMailService.createMailAndChangePassword(requestDto);
    sendMailService.mailSend(dto);
  }
}
