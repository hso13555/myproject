package com.example.demo.entity;

import com.example.demo.dto.response.RecipeItemRespDto;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeItem extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recipeItem_id")
  private Long id;

  @Column
  private String count;

  //재료
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;

  //레시피
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  public RecipeItemRespDto toDTO() {
    return RecipeItemRespDto
      .builder()
      .id(id)
      .itemName(item.getName())
      .itemCount(count)
      .recipeName(recipe.getName())
      .recipeImg(recipe.getImg())
      .build();
  }
}
