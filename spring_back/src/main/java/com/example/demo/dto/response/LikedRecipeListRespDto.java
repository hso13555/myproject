package com.example.demo.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LikedRecipeListRespDto {

  List<LikedRecipeRespDto> likedRecipeRespDto;

  @Builder
  public LikedRecipeListRespDto(List<LikedRecipeRespDto> likedRecipeRespDto) {
    this.likedRecipeRespDto = likedRecipeRespDto;
  }
}
