package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.mapper.RecipeMapper;
import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author sumutella
 * @time 10:54 AM
 * @since 12/25/2019, Wed
 */
class RecipeServiceImplTest {


    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipesTest() throws Exception{
        Recipe recipe = new Recipe();
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeList);
        List<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();

    }


    @Test
    public void getRecipeByIdTest() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe=Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        RecipeDto recipeFoundById = recipeService.findById(1L);

        assertNotNull(recipeFoundById, "Null Recipe Returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();

    }

    @Test
    public void deleteById() throws Exception{
        recipeService.deleteById(2L);
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }



}