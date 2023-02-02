package com.example.demo.service;

import com.example.demo.dto.request.RecipeReqDto;
import com.example.demo.dto.response.RecipeListRespDto;
import com.example.demo.dto.response.RecipeRespDto;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.RecipeRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class RecipeService {

  private final RecipeRepository recipeRepository;

  //레시피 등록
  public RecipeRespDto register(RecipeReqDto recipeReqDto) {
    Recipe recipe = recipeRepository.save(recipeReqDto.toEntity());
    return recipe.toDto();
  }

  //레시피 조회
  public RecipeRespDto readOne(Long id) {
    Recipe recipe = recipeRepository.findById(id).get();
    return recipe.toDto();
  }

  //레시피 수정
  public RecipeRespDto modify(RecipeReqDto recipeReqDto) {
    Recipe recipe = recipeRepository.findById(recipeReqDto.getId()).get();
    recipe.change(recipeReqDto);
    return recipe.toDto();
  }

  //삭제 처리
  public void remove(Long id) {
    recipeRepository.deleteById(id);
  }

  // 전체 목록
  public RecipeListRespDto readAll(Pageable pageable) {
    List<RecipeRespDto> resultList = recipeRepository
      .findAll(pageable)
      .stream()
      .map(Recipe::toDto)
      .collect(Collectors.toList());
    RecipeListRespDto recipeListRespDto = RecipeListRespDto
      .builder()
      .recipes(resultList)
      .build();

    return recipeListRespDto;
  }

  //레시피 카운트up
  public RecipeRespDto addCount(Long id) {
    Optional<Recipe> recipeOP = recipeRepository.findById(id);
    if (recipeOP.isPresent()) {
      Recipe result = recipeOP.get();
      result.addCount();
      return result.toDto();
    }
    return null;
  }
}
