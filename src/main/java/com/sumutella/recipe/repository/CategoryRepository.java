package com.sumutella.recipe.repository;

import com.sumutella.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sumutella
 * @time 11:20 PM
 * @since 12/23/2019, Mon
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
