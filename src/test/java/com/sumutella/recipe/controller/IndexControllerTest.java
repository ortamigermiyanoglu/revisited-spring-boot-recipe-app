package com.sumutella.recipe.controller;

import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.services.IngredientService;
import com.sumutella.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * @author sumutella
 * @time 11:13 AM
 * @since 12/25/2019, Wed
 */
class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    IngredientService ingredientService;
    @Mock
    Model model;

    MockMvc mockMvc;
    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController =new IndexController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    }


    @Test
    void testMockMVC() throws Exception{
        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void getIndexPage() {
        List<Recipe> recipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(4L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(5L);
        recipes.add(recipe1);
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);

        String viewName = indexController.getIndexPage(model);
        assertEquals("index", viewName);
        assertEquals(recipes.size(), 2);

        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anyList());
    }

//    @Test
//    void deleteIngredient() throws Exception {
//        //then
//        mockMvc.perform(get("/recipe/2/ingredient/11/delete")
//        )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/recipe/2/ingredients"));
//
//        verify(ingredientService, times(1)).deleteById( anyLong());
//    }
}