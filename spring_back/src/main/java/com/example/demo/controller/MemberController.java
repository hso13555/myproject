package com.example.demo.controller;

import com.example.demo.dto.request.ChangePasswordRequestDto;
import com.example.demo.dto.request.MemberReqDto;
import com.example.demo.dto.response.MemberRespDto;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/me")
  public ResponseEntity<MemberRespDto> getMyMemberInfo() {
    MemberRespDto myInfoBySecurity = memberService.getMyInfoBySecurity();
    System.out.println(myInfoBySecurity.getUserName());
    return ResponseEntity.ok((myInfoBySecurity));
  }

  @PostMapping("/username")
  public ResponseEntity<MemberRespDto> setMemberNickname(
    @RequestBody MemberReqDto request
  ) {
    return ResponseEntity.ok(
      memberService.changeMemberNickname(
        request.getUserEmail(),
        request.getUserName()
      )
    );
  }

  @PostMapping("/userpw")
  public ResponseEntity<MemberRespDto> setMemberPassword(
    @RequestBody ChangePasswordRequestDto dto
  ) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    return ResponseEntity.ok(
      memberService.changeMemberPassword(
        email,
        dto.getExUserPw(),
        dto.getNewUserPw()
      )
    );
  }

  @PostMapping("/userpwch")
  public ResponseEntity<?> memberPwCk(
    @RequestBody ChangePasswordRequestDto dto
  ) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    return ResponseEntity.ok(
      memberService.memberPwCk(email, dto.getExUserPw())
    );
  }
}
