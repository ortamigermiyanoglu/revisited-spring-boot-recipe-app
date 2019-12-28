package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.mapper.RecipeMapper;
import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sumutella
 * @time 6:49 PM
 * @since 12/28/2019, Sat
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeServiceTest {
    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    RecipeMapper recipeMapper;

    @BeforeEach
    void setUp() {
        recipeMapper = Mappers.getMapper(RecipeMapper.class);
    }

    @Test
    @Transactional
    void saveRecipe() throws Exception {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeDto recipeDto = recipeMapper.entityToDto(testRecipe);

        recipeDto.setDescription("new description");

        RecipeDto savedRecipeDto = recipeService.saveRecipe(recipeDto);

        assertEquals("new description",savedRecipeDto.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeDto.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeDto.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeDto.getIngredients().size());


    }
}