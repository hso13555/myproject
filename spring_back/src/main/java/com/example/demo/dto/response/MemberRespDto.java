package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberRespDto {

  private Long id;
  private String userEmail;
  private String userName;
  private String userPw;

  @Builder
  public MemberRespDto(
    Long id,
    String userEmail,
    String userName,
    String userPw
  ) {
    this.id = id;
    this.userEmail = userEmail;
    this.userName = userName;
    this.userPw = userPw;
  }
}
