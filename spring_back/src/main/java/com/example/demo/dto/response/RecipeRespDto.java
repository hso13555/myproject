package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RecipeRespDto {

  private Long id;

  private String name;

  private String img;

  private Integer count;

  @Builder
  public RecipeRespDto(Long id, String name, String img, Integer count) {
    this.id = id;
    this.name = name;
    this.img = img;
    this.count = count;
  }
}
