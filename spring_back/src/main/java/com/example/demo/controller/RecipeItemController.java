package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.RecipeItemReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.RecipeItemListRespDto;
import com.example.demo.dto.response.RecipeItemRespDto;
import com.example.demo.service.RecipeItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipeItem")
public class RecipeItemController {

  private final RecipeItemService recipeItemService;

  @PostMapping("/add") //레시피아이템 추가
  public ResponseEntity<?> addRecipe(@RequestBody RecipeItemReqDto dto)
    throws Exception {
    RecipeItemRespDto recipeItemRespDto = recipeItemService.addRecipeItem(dto);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피 아이템 등록 성공")
        .body(recipeItemRespDto)
        .build(),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/{name}") //해당 재료의 레시피아이템 전체조회
  public ResponseEntity<?> readAllRecipeItem(
    @PathVariable("name") String name
  ) {
    RecipeItemListRespDto recipeItemListRespDto = recipeItemService.recipeSearch(
      name
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("해당 재료의 레시피 전체 조회")
        .body(recipeItemListRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  @GetMapping("/recipe/{name}") //해당 레시피의 재료 전체조회
  public ResponseEntity<?> readAllItemRecipe(
    @PathVariable("name") String name
  ) {
    RecipeItemListRespDto recipeItemListRespDto = recipeItemService.itemSearch(
      name
    );
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("해당 레시피의 재료 전체 조회")
        .body(recipeItemListRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  @DeleteMapping
  public ResponseEntity<?> deleteRecipeItem(@RequestBody RecipeItemReqDto dto) {
    recipeItemService.deleteRecipeItem(dto);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피아이템 삭제 완료")
        .body(null)
        .build(),
      HttpStatus.OK
    );
  }
}
