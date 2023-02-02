package com.example.demo.service;

import com.example.demo.dto.TokenDto;
import com.example.demo.dto.request.MemberReqDto;
import com.example.demo.dto.response.MemberRespDto;
import com.example.demo.entity.Member;
import com.example.demo.jwt.TokenProvider;
import com.example.demo.repository.MemberRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class AuthService {

  private final AuthenticationManagerBuilder managerBuilder;
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenProvider tokenProvider;
  private final JwtService jwtService;

  public MemberRespDto signup(MemberReqDto requestDto) {
    if (memberRepository.existsByUserEmail(requestDto.getUserEmail())) {
      throw new RuntimeException("이미 가입되어 있는 유저입니다");
    }

    Member member = memberRepository.save(requestDto.toEntity(passwordEncoder));
    return member.toDto();
  }

  //로그인
  public TokenDto login(MemberReqDto requestDto) {
    UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

    Authentication authentication = managerBuilder
      .getObject()
      .authenticate(authenticationToken);
    TokenDto token = tokenProvider.generateTokenDto(authentication);
    log.info(token);
    jwtService.login(token);

    return token;
  }

  //아이디 중복 체크
  public boolean checkEmail(String email) {
    return memberRepository.existsByUserEmail(email);
  }

  //비밀번호 찾기시 이메일이름 체크
  public boolean checkEmailAndName(String userEmail, String userName) {
    Optional<Member> member = memberRepository.findByUserEmail(userEmail);
    if (member.isPresent() && member.get().getUserName().equals(userName)) {
      log.info(member);
      return true;
    } else {
      return false;
    }
  }
}
