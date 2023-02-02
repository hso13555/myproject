package com.example.demo.dto.request;

import com.example.demo.entity.Item;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.RecipeItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeItemReqDto {

  private Long id;

  private String count;

  private Item item;

  private Recipe recipe;

  public RecipeItem toEntity() {
    return RecipeItem
      .builder()
      .id(id)
      .item(item)
      .count(count)
      .recipe(recipe)
      .build();
  }
}
