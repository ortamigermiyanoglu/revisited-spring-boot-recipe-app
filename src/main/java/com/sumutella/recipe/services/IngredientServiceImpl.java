package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.IngredientDto;
import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.mapper.IngredientMapper;
import com.sumutella.recipe.mapper.RecipeMapper;
import com.sumutella.recipe.model.Ingredient;
import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.repository.RecipeRepository;
import com.sumutella.recipe.repository.UnitOfMeasureRepository;
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

    private final RecipeMapper recipeMapper = Mappers.getMapper(RecipeMapper.class);
    private final IngredientMapper ingredientMapper = Mappers.getMapper(IngredientMapper.class);
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public IngredientDto findIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        RecipeDto recipeDto = recipeMapper.entityToDto(recipeRepository.findById(recipeId).orElse(null));
        if (recipeDto==null){
            log.error("recipe with the id " + recipeId +" not found" );
        }

        assert recipeDto != null;
        Optional<IngredientDto> optionalIngredientDto = recipeDto.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientId)).findFirst();

        return optionalIngredientDto.orElse(null);
    }

    @Override
    public IngredientDto savedIngredientDto(Long recipeId, IngredientDto ingredientDto) {
        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);
        if (recipe==null){
            log.error("Recipe not found with id: " + recipeId);
            return new IngredientDto();
        }

        Ingredient ingredient = ingredientMapper.dtoToEntity(ingredientDto);
        ingredient.setRecipe(recipe);

        //unitOfMeasureRepository.save(ingredient.getUnitOfMeasure());


        recipe.getIngredients().add(ingredient);
        Recipe savedRecipe = recipeRepository.save(recipe);


        return ingredientMapper.entityToDto(savedRecipe.getIngredients().stream()
                .filter(recipeIngredient -> recipeIngredient.getId().equals(ingredientDto.getId()))
                .findFirst()
                .get());
    }
}
