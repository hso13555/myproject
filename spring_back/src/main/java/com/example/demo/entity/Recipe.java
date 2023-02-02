package com.example.demo.entity;

import com.example.demo.dto.request.RecipeReqDto;
import com.example.demo.dto.response.RecipeRespDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert //Default 값을 적용 하기 위한 어노테이션
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Recipe extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "recipe_id")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String img;

  @Column(nullable = false)
  @ColumnDefault("0") //@ColumnDefault사용
  private Integer count;

  @JsonIgnore
  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
  private List<LikedRecipe> likedRecipe;

  public void change(RecipeReqDto recipeReqDto) {
    this.name = recipeReqDto.getName();
  }

  public void addCount() {
    this.count += 1;
  }

  public RecipeRespDto toDto() {
    return RecipeRespDto
      .builder()
      .id(id)
      .name(name)
      .img(img)
      .count(count)
      .build();
  }
}
