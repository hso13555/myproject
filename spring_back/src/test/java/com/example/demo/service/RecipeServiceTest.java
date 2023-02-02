package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.demo.dto.request.RecipeReqDto;
import com.example.demo.dto.response.RecipeRespDto;
import com.example.demo.entity.Recipe;
import com.example.demo.repository.RecipeRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

  @InjectMocks
  private RecipeService recipeService;

  @Mock
  private RecipeRepository recipeRepository;

  @Test
  public void 레시피등록_테스트() {
    //given
    RecipeReqDto dto = new RecipeReqDto();
    dto.setName("김치찌개");
    dto.setCount(0);

    //stub
    when(recipeRepository.save(any())).thenReturn(dto.toEntity());

    //when
    RecipeRespDto recipeRespDto = recipeService.register(dto);

    //then
    assertThat(dto.getName()).isEqualTo(recipeRespDto.getName());
  }

  @Test
  public void 레시피카운트업_테스트() {
    //given
    Long id = 1L;
    //stub
    Recipe recipe = Recipe.builder().id(1L).name("된장찌개").count(0).build();
    Optional<Recipe> recipeOP = Optional.of(recipe);
    when(recipeRepository.findById(id)).thenReturn(recipeOP);
    System.out.println(recipeOP.get().getCount());
    //when
    RecipeRespDto recipeRespDto = recipeService.addCount(id);
    //then
    assertThat(recipeRespDto.getCount()).isEqualTo(1);
    // System.out.println("result" + recipeRespDto.getCount());
  }
}
