package com.sumutella.recipe.controller;

import com.sumutella.recipe.dto.IngredientDto;
import com.sumutella.recipe.dto.RecipeDto;
import com.sumutella.recipe.dto.UnitOfMeasureDto;
import com.sumutella.recipe.model.Ingredient;
import com.sumutella.recipe.services.IngredientService;
import com.sumutella.recipe.services.RecipeService;
import com.sumutella.recipe.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumutella
 * @time 7:32 PM
 * @since 12/29/2019, Sun
 */
@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;


    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable Long recipeId, Model model){
        log.debug("Getting ingredient list for recipe id: " + recipeId);

        model.addAttribute("recipe", recipeService.findById(recipeId));

        return "recipe/ingredient/list";
    }

    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable Long recipeId,
                                       @PathVariable Long id, Model model){
        model.addAttribute("ingredient", ingredientService.findIngredientByRecipeIdAndIngredientId(recipeId, id));
        return "recipe/ingredient/show";
    }

    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable Long recipeId,
                                         @PathVariable Long id, Model model){
        model.addAttribute("ingredient", ingredientService.findIngredientByRecipeIdAndIngredientId(recipeId, id));
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
        return "recipe/ingredient/ingredient-form";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientDto ingredientDto, @PathVariable Long recipeId){
        IngredientDto savedIngredientDto = ingredientService.savedIngredientDto(recipeId, ingredientDto);

        log.debug("saved ingredient id:" + savedIngredientDto.getId());

        return "redirect:/recipe/" + recipeId + "/ingredient/" + savedIngredientDto.getId() + "/show";
    }

    @RequestMapping("recipe/{recipeId}/ingredient/new")
    public String newIngredient(@PathVariable Long recipeId, Model model){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setUnitOfMeasure(new UnitOfMeasureDto());
        model.addAttribute("ingredient", ingredientDto);
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/ingredient-form";
    }

    @RequestMapping("recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteIngredient(@PathVariable Long recipeId,
                                   @PathVariable Long id){

        log.debug("deleting ingredient id:" + id);
        ingredientService.deleteById(id);

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }

}
