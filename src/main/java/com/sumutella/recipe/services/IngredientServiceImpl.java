package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.IngredientDto;
import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.mapper.IngredientMapper;
import com.sumutella.recipe.mapper.RecipeMapper;
import com.sumutella.recipe.model.Ingredient;
import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.repository.IngredientRepository;
import com.sumutella.recipe.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sumutella
 * @time 10:08 AM
 * @since 12/30/2019, Mon
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientMapper ingredientMapper = Mappers.getMapper(IngredientMapper.class);
    private final IngredientRepository ingredientRepository;


    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public IngredientDto findIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {


        Optional<Ingredient> ingredient = ingredientRepository.findByRecipeIdAndId(recipeId, ingredientId);

        return ingredientMapper.entityToDto(ingredient.orElse(null));
    }



    @Override
    public IngredientDto savedIngredientDto(Long recipeId, IngredientDto ingredientDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);


        Ingredient ingredient = ingredientMapper.dtoToEntity(ingredientDto);
        ingredient.setRecipe(recipe);

        Ingredient savedIngredient = ingredientRepository.save(ingredient);



        return ingredientMapper.entityToDto(savedIngredient);
    }
}
