package com.sumutella.recipe.mapper;

import com.sumutella.recipe.dto.IngredientDto;
import com.sumutella.recipe.model.Ingredient;
import org.mapstruct.Mapper;

/**
 * @author sumutella
 * @time 2:38 PM
 * @since 12/28/2019, Sat
 */
@Mapper
public interface IngredientMapper {
    Ingredient dtoToEntity(IngredientDto ingredientDto);
    IngredientDto entityToDto(Ingredient ingredient);
}
