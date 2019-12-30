package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.IngredientDto;

/**
 * @author sumutella
 * @time 10:05 AM
 * @since 12/30/2019, Mon
 */
public interface IngredientService {
    IngredientDto findIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
