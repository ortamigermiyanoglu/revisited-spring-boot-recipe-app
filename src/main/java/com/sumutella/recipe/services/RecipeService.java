package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.model.Recipe;

import java.util.List;
import java.util.Optional;

/**
 * @author sumutella
 * @time 8:57 PM
 * @since 12/24/2019, Tue
 */

public interface RecipeService {

    List<Recipe> getRecipes();
    RecipeDto findById(Long id);
    RecipeDto saveRecipe(RecipeDto recipeDto);
    void deleteById(Long id);

}
