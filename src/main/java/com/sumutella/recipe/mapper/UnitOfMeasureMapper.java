package com.sumutella.recipe.mapper;

import com.sumutella.recipe.dto.UnitOfMeasureDto;
import com.sumutella.recipe.model.UnitOfMeasure;
import org.mapstruct.Mapper;

/**
 * @author sumutella
 * @time 2:43 PM
 * @since 12/28/2019, Sat
 */
@Mapper
public interface UnitOfMeasureMapper {
    UnitOfMeasure dtoToEntity(UnitOfMeasureDto unitOfMeasureDto);
    UnitOfMeasureDto entityToDto(UnitOfMeasure unitOfMeasure);
}
