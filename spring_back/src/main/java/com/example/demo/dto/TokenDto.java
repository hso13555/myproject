package com.example.demo.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {

  private String grantType;
  private String accessToken;
  private String refreshToken;
  private String key;
  private Date accessTokenExp;
}
//토큰의 값을 헤더에서 뽑거나 헤더에서 삽입할때 쓰는 dto
