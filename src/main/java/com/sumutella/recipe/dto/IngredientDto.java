package com.sumutella.recipe.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author sumutella
 * @time 2:20 PM
 * @since 12/28/2019, Sat
 */
@Getter
@Setter
public class IngredientDto {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureDto unitOfMeasure;
}
