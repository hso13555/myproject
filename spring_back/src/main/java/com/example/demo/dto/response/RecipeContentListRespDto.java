package com.example.demo.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RecipeContentListRespDto {

  List<RecipeContentRespDto> recipeContentList;

  @Builder
  public RecipeContentListRespDto(
    List<RecipeContentRespDto> recipeContentList
  ) {
    this.recipeContentList = recipeContentList;
  }
}
