package com.example.demo.config;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder
      .getContext()
      .getAuthentication(); // 현재 로그인한 사용자 정보 조회
    String userId = "";
    if (authentication != null) {
      userId = authentication.getName(); //사용자의 이름을 등록자와 수정자로 지정함.
    }
    return Optional.of(userId);
  }
}
