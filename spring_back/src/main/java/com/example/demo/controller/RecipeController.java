package com.example.demo.controller;

import com.example.demo.dto.request.RecipeReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.RecipeListRespDto;
import com.example.demo.dto.response.RecipeRespDto;
import com.example.demo.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipe")
public class RecipeController {

  private final RecipeService recipeService;

  @PostMapping("/add") //레시피 추가
  public ResponseEntity<?> addRecipe(@RequestBody RecipeReqDto recipeReqDto)
    throws Exception {
    RecipeRespDto recipeRespDto = recipeService.register(recipeReqDto);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피 추가 성공")
        .body(recipeRespDto)
        .build(),
      HttpStatus.CREATED
    );
  }

  @PutMapping("/{recipeId}") //레시피 수정 망
  public ResponseEntity<?> modifyRecipe(
    @PathVariable("recipeId") Long recipeId,
    @RequestBody RecipeReqDto recipeReqDto
  ) throws Exception {
    RecipeRespDto recipeRespDto = recipeService.modify(recipeReqDto);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피 수정 성공")
        .body(recipeRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  @GetMapping // 레시피 목록 받기
  public ResponseEntity<?> readAllRecipe(Pageable pageable) throws Exception {
    RecipeListRespDto recipeListRespDto = recipeService.readAll(pageable);
    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피 전체 목록 받기 성공")
        .body(recipeListRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  @GetMapping("/{recipeId}")
  public ResponseEntity<?> readOneRecipe(
    @PathVariable("recipeId") Long recipeId
  ) throws Exception {
    RecipeRespDto recipeRespDto = recipeService.readOne(recipeId);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("레시피 한개 목록 받기 성공")
        .body(recipeRespDto)
        .build(),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/{recipeId}")
  public ResponseEntity<?> deleteRecipe(
    @PathVariable("recipeId") Long recipeId
  ) throws Exception {
    recipeService.remove(recipeId);
    return new ResponseEntity<>(
      CMRespDto.builder().code(1).msg("레시피 삭제 성공").body(null).build(),
      HttpStatus.OK
    );
  }

  @PutMapping("/count/{recipeId}")
  public ResponseEntity<?> addCount(@PathVariable("recipeId") Long recipeId) {
    RecipeRespDto dto = recipeService.addCount(recipeId);
    return new ResponseEntity<>(
      CMRespDto.builder().code(1).msg("카운트 업!").body(dto).build(),
      HttpStatus.OK
    );
  }
}
