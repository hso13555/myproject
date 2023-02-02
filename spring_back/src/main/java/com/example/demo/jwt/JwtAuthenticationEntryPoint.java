package com.example.demo.jwt;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.demo.util.Code;
import com.google.gson.JsonObject;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(
          HttpServletRequest request,
          HttpServletResponse response,
          AuthenticationException authException
  ) throws IOException {
      Object exception = (Object)request.getAttribute("exception");

      if(exception == null) {
          setResponse(response, Code.FAILED_MESSAGE);
      }
      //잘못된 타입의 토큰인 경우
      else if(exception.equals(Code.WRONG_TYPE_TOKEN.getCode())) {
          setResponse(response, Code.WRONG_TYPE_TOKEN);
      }
      else if(exception.equals(Code.WRONG_TYPE_SIGNATURE.getCode())) {
          setResponse(response, Code.WRONG_TYPE_SIGNATURE);
      }
      //토큰 만료된 경우
      else if(exception.equals(Code.EXPIRED_TOKEN.getCode())) {
            log.info("엔트리포인트 까지 왔음 만료!");
          setResponse(response, Code.EXPIRED_TOKEN);
      }
      else {
          setResponse(response, Code.UNSUPPORTED_TOKEN);
      }
  }

  //한글 출력을 위해 getWriter() 사용
  private void setResponse(HttpServletResponse response, Code errorCode) throws IOException {
      response.setContentType("application/json;charset=UTF-8");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

      JsonObject responseJson = new JsonObject();
      responseJson.addProperty("timestamp", String.valueOf(LocalDateTime.now()));
      responseJson.addProperty("code", errorCode.getCode());
      responseJson.addProperty("message", errorCode.getMessage());

      response.getWriter().print(responseJson);
  }
}