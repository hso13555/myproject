package com.example.demo.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RecipeListRespDto {

  List<RecipeRespDto> recipes;

  @Builder
  public RecipeListRespDto(List<RecipeRespDto> recipes) {
    this.recipes = recipes;
  }
}
