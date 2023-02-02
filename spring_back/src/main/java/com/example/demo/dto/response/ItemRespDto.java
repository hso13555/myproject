package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemRespDto {

  private Long id;

  private String name;

  private String img;

  @Builder
  public ItemRespDto(Long id, String name, String img) {
    this.id = id;
    this.name = name;
    this.img = img;
  }
}
