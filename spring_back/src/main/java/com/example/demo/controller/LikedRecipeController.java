package com.example.demo.controller;

import com.example.demo.dto.request.LikedRecipeReqDto;
import com.example.demo.dto.response.CMRespDto;
import com.example.demo.dto.response.LikedRecipeListRespDto;
import com.example.demo.dto.response.LikedRecipeRespDto;
import com.example.demo.service.LikedRecipeService;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/liked")
public class LikedRecipeController {

  private final LikedRecipeService likedRecipeService;
  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<?> addLikedRecipe(@RequestBody LikedRecipeReqDto dto) {
    System.out.println("dtost" + dto);
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    LikedRecipeRespDto response = likedRecipeService.addLikedRecipe(dto, email);

    return new ResponseEntity<>(
      CMRespDto
        .builder()
        .code(1)
        .msg("좋아요 추가 완료")
        .body(response)
        .build(),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/{recipeId}")
  public ResponseEntity<?> existLikedRecipe(
    @PathVariable("recipeId") Long recipeId
  ) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    Boolean response = likedRecipeService.existLikedRecipe(recipeId, email);
    return new ResponseEntity<>(
      CMRespDto.builder().code(1).msg("조회 완료").body(response).build(),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/{recipeId}")
  public ResponseEntity<?> deleteLikedRecipe(
    @PathVariable("recipeId") Long recipeId
  ) {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    likedRecipeService.deleteLikedRecipe(recipeId, email);

    return new ResponseEntity<>(
      CMRespDto.builder().code(1).msg("좋아요 삭제 완료").body(null).build(),
      HttpStatus.OK
    );
  }

  @GetMapping("/me")
  public ResponseEntity<?> getLikedList() {
    String email = memberService.getMyInfoBySecurity().getUserEmail();
    LikedRecipeListRespDto dto = likedRecipeService.getLikedRecipe(email);
    return new ResponseEntity<>(
      CMRespDto.builder().code(1).msg("조회 완료").body(dto).build(),
      HttpStatus.OK
    );
  }
}
