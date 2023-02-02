package com.example.demo.entity;

import com.example.demo.dto.response.RecipeContentRespDto;
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
public class RecipeList extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recipeList_id")
  private Long id;

  @Column(nullable = false)
  private int recipeListNo;

  @Column(nullable = false)
  private String recipeList;

  @Column(nullable = false)
  private String imgUrl;

  //레시피
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  public RecipeContentRespDto toDto() {
    return RecipeContentRespDto
      .builder()
      .id(id)
      .recipeListNo(recipeListNo)
      .imgUrl(imgUrl)
      .recipeList(recipeList)
      .build();
  }
}
