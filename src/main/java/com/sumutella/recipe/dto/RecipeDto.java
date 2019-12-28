package com.sumutella.recipe.dto;

import com.sumutella.recipe.model.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumutella
 * @time 2:21 PM
 * @since 12/28/2019, Sat
 */
@Setter
@Getter
public class RecipeDto {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private List<IngredientDto> ingredients = new ArrayList<>();
    private Difficulty difficulty;
    private NoteDto note;
    private List<CategoryDto> categories = new ArrayList<>();
}
