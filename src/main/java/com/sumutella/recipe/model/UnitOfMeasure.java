package com.sumutella.recipe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author sumutella
 * @time 9:37 PM
 * @since 12/23/2019, Mon
 */

@Entity
@Getter
@Setter
public class UnitOfMeasure extends BaseEntity {
    private String description;
}
