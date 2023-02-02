package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.RecipeItemService;

public class RecipeItemRepositoryTest {

  @Autowired
  RecipeItemRepository recipeItemRepository;

  @Autowired
  RecipeItemService recipeItemService;

  @Test
  void testFindByItemName() {
  recipeItemRepository.findByRecipeName("닭볶음탕");


  }

  @Test
  void testFindByRecipeName() {

  }

  @Test
  void testFindByRecipeNameAndItemName() {

  }
}
