package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RecipeContentRespDto {

  private Long id;

  private String recipeList;

  private int recipeListNo;

  private String imgUrl;

  @Builder
  public RecipeContentRespDto(
    Long id,
    String recipeList,
    int recipeListNo,
    String imgUrl
  ) {
    this.id = id;
    this.recipeList = recipeList;
    this.recipeListNo = recipeListNo;
    this.imgUrl = imgUrl;
  }
}
