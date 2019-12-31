package com.sumutella.recipe.controller;

import com.sumutella.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumutella
 * @time 10:08 AM
 * @since 12/23/2019, Mon
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping({"", "/", "/index", "index.html"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
