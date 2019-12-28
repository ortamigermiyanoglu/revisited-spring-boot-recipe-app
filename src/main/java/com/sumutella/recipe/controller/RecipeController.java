package com.sumutella.recipe.controller;

import com.sumutella.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumutella
 * @time 8:33 AM
 * @since 12/28/2019, Sat
 */
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{recipeId}")
    public String showById(@PathVariable Long recipeId, Model model){
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "/recipe/show";
    }
}
