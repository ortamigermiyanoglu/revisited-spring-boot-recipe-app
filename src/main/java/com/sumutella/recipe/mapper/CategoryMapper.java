package com.sumutella.recipe.mapper;

import com.sumutella.recipe.dto.CategoryDto;
import com.sumutella.recipe.model.Category;
import org.mapstruct.Mapper;

/**
 * @author sumutella
 * @time 2:37 PM
 * @since 12/28/2019, Sat
 */
@Mapper
public interface CategoryMapper {
    Category dtoToEntity(CategoryDto categoryDto);
    CategoryDto entityToDto(Category category);
}
