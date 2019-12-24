package com.sumutella.recipe.repository;

import com.sumutella.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author sumutella
 * @time 11:20 PM
 * @since 12/23/2019, Mon
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String american);
}
