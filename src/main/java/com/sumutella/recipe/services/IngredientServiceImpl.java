package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.IngredientDto;
import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.mapper.IngredientMapper;
import com.sumutella.recipe.mapper.RecipeMapper;
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
    private final RecipeMapper recipeMapper = Mappers.getMapper(RecipeMapper.class);
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public IngredientDto findIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        RecipeDto recipeDto = recipeMapper.entityToDto(recipeRepository.findById(recipeId).orElse(null));
        if (recipeDto==null){
            log.error("recipe with the id " + recipeId +" not found" );
        }

        assert recipeDto != null;
        Optional<IngredientDto> optionalIngredientDto = recipeDto.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientId)).findFirst();

        return optionalIngredientDto.get();
    }
}
