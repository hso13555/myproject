package com.example.demo.repository;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.RecipeList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeListRepository extends JpaRepository<RecipeList, Long> {
  List<RecipeList> findByRecipe(Recipe recipe);
}
