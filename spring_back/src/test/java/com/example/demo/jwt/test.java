package com.example.demo.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class test {

  @Autowired
  private MockMvc mockMvc;



  @Test
  public void postHome() throws Exception {
      String requestJson = "{\"userEmail\":\"minnseong\", \"userPw\": \"1234\"}";
      String responseJson = "{}";

      mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(requestJson))
              .andExpect(MockMvcResultMatchers.status().isOk())
              .andExpect(MockMvcResultMatchers.content().string(responseJson))
              .andDo(MockMvcResultHandlers.print());
  }
  
}
