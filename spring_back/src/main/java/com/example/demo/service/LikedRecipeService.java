package com.example.demo.service;

import com.example.demo.dto.request.LikedRecipeReqDto;
import com.example.demo.dto.response.LikedRecipeListRespDto;
import com.example.demo.dto.response.LikedRecipeRespDto;
import com.example.demo.entity.LikedRecipe;
import com.example.demo.entity.Member;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.LikedRecipeRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.RecipeRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikedRecipeService {

  private final LikedRecipeRepository likedRecipeRepository;
  private final MemberRepository memberRepository;
  private final RecipeRepository recipeRepository;

  //등록
  public LikedRecipeRespDto addLikedRecipe(
    LikedRecipeReqDto dto,
    String email
  ) {
    Member member = memberRepository.findByUserEmail(email).orElseThrow();
    dto.setMember(member);
    Long recipeId = dto.getRecipeId();
    Optional<Recipe> recipe = recipeRepository.findById(recipeId);
    if (recipe.isPresent()) {
      dto.setRecipe(recipe.get());
      LikedRecipe likedRecipe = likedRecipeRepository.save(dto.toEntity());
      return likedRecipe.toDto();
    }
    return null;
  }

  //삭제
  public void deleteLikedRecipe(Long recipeId, String email) {
    Member member = memberRepository.findByUserEmail(email).orElseThrow();
    Long memberId = member.getId();
    LikedRecipe likedRecipe = likedRecipeRepository.findByRecipeIdAndMemberId(
      recipeId,
      memberId
    );
    likedRecipeRepository.delete(likedRecipe);
  }

  //한개 있는지 조회
  public Boolean existLikedRecipe(Long recipeId, String email) {
    Member member = memberRepository.findByUserEmail(email).orElseThrow();
    Long memberId = member.getId();
    Boolean boolean1 = likedRecipeRepository.existsByRecipeIdAndMemberId(
      recipeId,
      memberId
    );
    return boolean1;
  }

  //멤버당 전체조회
  public LikedRecipeListRespDto getLikedRecipe(String email) {
    Member member = memberRepository.findByUserEmail(email).orElseThrow();
    Long memberId = member.getId();
    List<LikedRecipeRespDto> list = likedRecipeRepository
      .findByMemberId(memberId)
      .stream()
      .map(LikedRecipe::toDto)
      .collect(Collectors.toList());

    LikedRecipeListRespDto likedRecipeListRespDto = LikedRecipeListRespDto
      .builder()
      .likedRecipeRespDto(list)
      .build();

    return likedRecipeListRespDto;
  }
}
