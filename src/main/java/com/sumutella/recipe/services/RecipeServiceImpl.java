package com.sumutella.recipe.services;

import com.sumutella.recipe.model.Recipe;
import com.sumutella.recipe.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sumutella
 * @time 8:58 PM
 * @since 12/24/2019, Tue
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public List<Recipe> getRecipes() {
        log.debug("I'm in the recipe service get recipes method");
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (!optionalRecipe.isPresent()){
            throw new RuntimeException("Recipe Not Found");
        }
        return optionalRecipe.get();
    }


}
