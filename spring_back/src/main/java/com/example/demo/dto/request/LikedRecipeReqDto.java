package com.example.demo.dto.request;

import com.example.demo.entity.LikedRecipe;
import com.example.demo.entity.Member;
import com.example.demo.entity.Recipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikedRecipeReqDto {

  private Member member;

  private Recipe recipe;

  private Long recipeId;

  public LikedRecipe toEntity() {
    return LikedRecipe.builder().member(member).recipe(recipe).build();
  }
}
