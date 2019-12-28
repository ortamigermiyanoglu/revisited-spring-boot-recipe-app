package com.sumutella.recipe.mapper;

import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.model.Recipe;
import org.mapstruct.Mapper;

/**
 * @author sumutella
 * @time 2:40 PM
 * @since 12/28/2019, Sat
 */
@Mapper
public interface RecipeMapper {
    Recipe dtoToEntity(RecipeDto recipeDto);
    RecipeDto entityToDto(Recipe recipe);
}
