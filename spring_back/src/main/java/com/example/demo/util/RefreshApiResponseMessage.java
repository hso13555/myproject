package com.example.demo.util;

import java.util.Map;

import org.modelmapper.spi.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshApiResponseMessage{
  
    public RefreshApiResponseMessage(Map<String, String> map) {
  }
    private int code;
    private boolean status;
    private String message;
    private Map<String, Object> data;
    private ErrorMessage error;

 

}

 
