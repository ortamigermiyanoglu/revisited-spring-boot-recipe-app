package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.IngredientDto;
import com.sumutella.recipe.mapper.IngredientMapper;
import com.sumutella.recipe.model.Ingredient;
import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.repository.IngredientRepository;
import com.sumutella.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author sumutella
 * @time 10:26 PM
 * @since 12/30/2019, Mon
 */
class IngredientServiceImplTest {
    IngredientMapper ingredientMapper = Mappers.getMapper(IngredientMapper.class);


    @Mock
    IngredientRepository ingredientRepository;

    IngredientService ingredientService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientServiceImpl(ingredientRepository);
    }

    @Test
    void findIngredientByRecipeIdAndIngredientId() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(3L);


        ingredient1.setRecipe(recipe);

        recipe.getIngredients().add(ingredient1);

        Optional<Ingredient> ingredientOptional = Optional.of(ingredient1);

        when(ingredientRepository.findByRecipeIdAndId(anyLong(), anyLong())).thenReturn(ingredientOptional);


        IngredientDto ingredientDto = ingredientMapper.entityToDto(ingredientRepository.findByRecipeIdAndId(1L, 3L).orElse(null));

        assertEquals(Long.valueOf(3L), ingredientDto.getId());
        verify(ingredientRepository, times(1)).findByRecipeIdAndId(anyLong(),anyLong());



    }

    @Test
    void saveIngredientDto() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(3L);
        ingredient.setRecipe(recipe);

        when(ingredientRepository.save(any())).thenReturn(ingredient);

        Ingredient savedIngredient = ingredientRepository.save(ingredient);

        assertEquals(Long.valueOf(3L), savedIngredient.getId());
        verify(ingredientRepository, times(1)).save(any(Ingredient.class));

    }
}