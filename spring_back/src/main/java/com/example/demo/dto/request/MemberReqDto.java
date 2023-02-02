package com.example.demo.dto.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.Authority;
import com.example.demo.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberReqDto {

  private String userEmail;
  private String userPw;
  private String userName;

  public Member toEntity (PasswordEncoder passwordEncoder) {
    return Member
      .builder()
      .userEmail(userEmail)
      .userPw(passwordEncoder.encode(userPw))
      .userName(userName)
      .authority(Authority.ROLE_USER)
      .build();
  }

  public UsernamePasswordAuthenticationToken toAuthentication() {
    return new UsernamePasswordAuthenticationToken(userEmail, userPw);
  }
}
