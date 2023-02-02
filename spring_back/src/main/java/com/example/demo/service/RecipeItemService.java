package com.example.demo.service;

import com.example.demo.dto.request.RecipeItemReqDto;
import com.example.demo.dto.response.RecipeItemListRespDto;
import com.example.demo.dto.response.RecipeItemRespDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.Recipe;
import com.example.demo.entity.RecipeItem;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.RecipeItemRepository;
import com.example.demo.repository.RecipeRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipeItemService {

  private final RecipeItemRepository recipeItemRepository;
  private final RecipeRepository recipeRepository;
  private final ItemRepository itemRepository;

  //레시피아이템 등록
  public RecipeItemRespDto addRecipeItem(RecipeItemReqDto dto) {
    RecipeItem savedRecipeItem = recipeItemRepository.findByRecipeNameAndItemName(
      dto.getRecipe().getName(),
      dto.getItem().getName()
    );
    if (savedRecipeItem != null) {
      return savedRecipeItem.toDTO();
    } else {
      Recipe recipe = recipeRepository.findByName(dto.getRecipe().getName());
      Item item = itemRepository.findByName(dto.getItem().getName());
      RecipeItem recipeItem = RecipeItem
        .builder()
        .item(item)
        .recipe(recipe)
        .build();

      recipeItemRepository.save(recipeItem);
      return recipeItem.toDTO();
    }
  }

  //레시피로 검색시 재료 리스트
  public RecipeItemListRespDto recipeSearch(String name) {
    List<RecipeItemRespDto> recipeItemListDto = recipeItemRepository
      .findByRecipeName(name)
      .stream()
      .map(RecipeItem::toDTO)
      .collect(Collectors.toList());

    RecipeItemListRespDto recipeItemListRespDto = RecipeItemListRespDto
      .builder()
      .recipeItems(recipeItemListDto)
      .build();

    return recipeItemListRespDto;
  }

  //재료로 검색시 만들수 있는 레시피
  public RecipeItemListRespDto itemSearch(String name) {
    List<RecipeItemRespDto> recipeItemListDto = recipeItemRepository
      .findByItemName(name)
      .stream()
      .map(RecipeItem::toDTO)
      .collect(Collectors.toList());

    RecipeItemListRespDto recipeItemListRespDto = RecipeItemListRespDto
      .builder()
      .recipeItems(recipeItemListDto)
      .build();

    return recipeItemListRespDto;
  }

  //삭제
  public void deleteRecipeItem(RecipeItemReqDto dto) {
    RecipeItem savedRecipeItem = recipeItemRepository.findByRecipeNameAndItemName(
      dto.getRecipe().getName(),
      dto.getItem().getName()
    );
    recipeItemRepository.delete(savedRecipeItem);
  }
}
