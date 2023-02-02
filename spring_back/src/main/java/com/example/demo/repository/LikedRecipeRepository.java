package com.example.demo.repository;

import com.example.demo.entity.LikedRecipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedRecipeRepository
  extends JpaRepository<LikedRecipe, Long> {
  LikedRecipe findByRecipeIdAndMemberId(Long recipeId, Long memberId);
  boolean existsByRecipeIdAndMemberId(Long recipeId, Long memberId);
  List<LikedRecipe> findByMemberId(Long memberId);
}
