package com.example.demo.dto.response;

import com.example.demo.entity.Member;
import com.example.demo.entity.Recipe;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LikedRecipeRespDto {

  private Long id;

  private Recipe recipe;

  private Member member;

  @Builder
  public LikedRecipeRespDto(Long id, Recipe recipe, Member member) {
    this.id = id;
    this.recipe = recipe;
    this.member = member;
  }
}
