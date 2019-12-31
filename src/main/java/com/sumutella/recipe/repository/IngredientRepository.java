package com.sumutella.recipe.repository;

import com.sumutella.recipe.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author sumutella
 * @time 12:50 PM
 * @since 12/31/2019, Tue
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByRecipeIdAndId(Long recipeId, Long ingredientId);
}
