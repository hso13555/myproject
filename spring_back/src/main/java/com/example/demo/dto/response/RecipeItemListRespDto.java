package com.example.demo.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RecipeItemListRespDto {

  List<RecipeItemRespDto> recipeItems;

  @Builder
  public RecipeItemListRespDto(List<RecipeItemRespDto> recipeItems) {
    this.recipeItems = recipeItems;
  }
}
