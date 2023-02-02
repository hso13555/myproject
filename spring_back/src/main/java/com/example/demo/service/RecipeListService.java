package com.example.demo.service;

import com.example.demo.dto.request.RecipeContentReqDto;
import com.example.demo.dto.response.RecipeContentListRespDto;
import com.example.demo.dto.response.RecipeContentRespDto;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.RecipeList;
import com.example.demo.repository.RecipeListRepository;
import com.example.demo.repository.RecipeRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class RecipeListService {

  private final RecipeListRepository recipeListRepository;
  private final RecipeRepository recipeRepository;

  //레시피 리스트 등록
  public RecipeContentRespDto addRecipeList(RecipeContentReqDto dto) {
    Recipe recipe = recipeRepository.findByName(dto.getRecipeName());
    RecipeList recipeList = RecipeList
      .builder()
      .recipe(recipe)
      .recipeList(dto.getRecipeList())
      .imgUrl(dto.getImgUrl())
      .build();

    recipeListRepository.save(recipeList);
    return recipeList.toDto();
  }

  //레시피이름으로 레시피 리스트 쭉 받아오기
  public RecipeContentListRespDto recipeListSearch(String name) {
    Recipe recipe = recipeRepository.findByName(name);
    List<RecipeList> recipeList = recipeListRepository.findByRecipe(recipe);

    log.info("fucking" + recipeList);
    List<RecipeContentRespDto> recipeItemListDto = recipeList
      .stream()
      .map(RecipeList::toDto)
      .collect(Collectors.toList());
    log.info("recipe" + recipeItemListDto);
    RecipeContentListRespDto recipeContentListRespDto = RecipeContentListRespDto
      .builder()
      .recipeContentList(recipeItemListDto)
      .build();
    log.info("recipe" + recipeContentListRespDto);
    return recipeContentListRespDto;
  }
  //   //재료로 검색시 만들수 있는 레시피
  //   public List<RecipeItemResponseDto> itemSearch(String name) {
  //     List<RecipeItem> recipeItemList = recipeItemRepository.findByItemName(name);
  //     List<RecipeItemResponseDto> recipeItemListDto = recipeItemList
  //       .stream()
  //       .map(RecipeItemResponseDto::of)
  //       .collect(Collectors.toList());

  //     return recipeItemListDto;
  //   }

  //   //삭제
  //   public void deleteRecipeItem(RecipeItemRequestDto dto) {
  //     RecipeItem savedRecipeItem = recipeItemRepository.findByRecipeNameAndItemName(
  //       dto.getRecipeName(),
  //       dto.getItemName()
  //     );
  //     recipeItemRepository.delete(savedRecipeItem);
  //   }
  // }

}
