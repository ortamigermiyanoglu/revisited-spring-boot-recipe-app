package com.sumutella.recipe.repository;

import com.sumutella.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sumutella
 * @time 11:19 PM
 * @since 12/23/2019, Mon
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long > {
}
