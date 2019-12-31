package com.sumutella.recipe.controller;

import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.mapper.RecipeMapper;
import com.sumutella.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author sumutella
 * @time 8:33 AM
 * @since 12/28/2019, Sat
 */
@Slf4j
@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper = Mappers.getMapper(RecipeMapper.class);

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{recipeId}/show")
    public String showById(@PathVariable Long recipeId, Model model){
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "/recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeDto());

        return "recipe/recipe-form";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe", recipeService.findById(id));
        return  "recipe/recipe-form";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeDto recipe){
        RecipeDto savedRecipeDto = recipeService.saveRecipe(recipe);

        return "redirect:/recipe/" + savedRecipeDto.getId() + "/show";
    }

    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){

        log.debug("Deleting id: " + id);

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

}
