package com.example.demo.controller;

import com.example.demo.dto.request.RecipeContentReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.RecipeContentListRespDto;
import com.example.demo.dto.response.RecipeContentRespDto;
import com.example.demo.service.RecipeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipeList")
public class RecipeListController {

  private final RecipeListService recipeListService;

  @PostMapping("/add") //레시피아이템 추가
  public ResponseEntity<?> addRecipe(@RequestBody RecipeContentReqDto dto)
    throws Exception {
    RecipeContentRespDto recipeContentRespDto = recipeListService.addRecipeList(
      dto
    );

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피컨텐트 등록 성공")
        .body(recipeContentRespDto)
        .build(),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/{recipeName}") //해당 레시피의 레시피아이템 전체조회
  public ResponseEntity<?> readAllRecipeItem(
    @PathVariable("recipeName") String RecipeName
  ) {
    RecipeContentListRespDto recipeContentListRespDto = recipeListService.recipeListSearch(
      RecipeName
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피컨텐트 전체조회 성공")
        .body(recipeContentListRespDto)
        .build(),
      HttpStatus.OK
    );
  }
  //   @GetMapping("/recipe/{name}") //해당 레시피의 레시피아이템 전체조회
  //   public List<RecipeItemResponseDto> readAllItemRecipe(
  //     @PathVariable("name") String name
  //   ) {
  //     return recipeItemService.itemSearch(name);
  //   }

  //   @DeleteMapping
  //   public void deleteRecipeItem(@RequestBody RecipeItemRequestDto dto) {
  //     recipeItemService.deleteRecipeItem(dto);
  //   }
}
