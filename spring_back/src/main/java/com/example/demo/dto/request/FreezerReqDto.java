package com.example.demo.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.entity.Freezer;
import com.example.demo.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreezerReqDto {

  private Long id;
  
  @Size(min = 1, max = 10)
  @NotBlank
  private String name;
  
  private Member member;


  public Freezer toEntity() {
    return Freezer.builder().id(id).name(name).member(member).build();
  }
}
