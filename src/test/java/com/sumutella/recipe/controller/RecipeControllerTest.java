package com.sumutella.recipe.controller;

import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author sumutella
 * @time 8:50 AM
 * @since 12/28/2019, Sat
 */
class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController recipeController;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

    }

    @Test
    public void getRecipe() throws Exception {
        RecipeDto recipe = new RecipeDto();
        recipe.setId(1L);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);


        mockMvc.perform(get("/recipe/1/show")).andExpect(status().isOk())
                .andExpect(view().name("/recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void getNewRecipeForm() throws Exception{
        RecipeDto recipeDto = new RecipeDto();

        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipe-form"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void postNewRecipeForm() throws Exception{
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(2L);

        when(recipeService.saveRecipe(any())).thenReturn(recipeDto);

        mockMvc.perform(post("/recipe")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some string"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/show"));

    }

    @Test
    public void getUpdateView() throws Exception{
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(2L);

        when(recipeService.findById(anyLong())).thenReturn(recipeDto);
        mockMvc.perform(get("/recipe/1/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipe-form"))
                .andExpect(model().attributeExists("recipe"));

    }

}