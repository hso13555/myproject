package com.example.demo.dto.request;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.RecipeList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeContentReqDto {

  private Long id;

  @JsonIgnore
  private Recipe recipe;

  private String recipeName;

  private String imgUrl;

  private String recipeList;

public RecipeList toEntity(){
  return RecipeList.builder().id(id).recipeList(recipeList).recipe(recipe).imgUrl(imgUrl).build();
}
  }
