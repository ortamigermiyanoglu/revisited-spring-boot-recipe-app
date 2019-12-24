package com.sumutella.recipe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * @author sumutella
 * @time 9:13 PM
 * @since 12/23/2019, Mon
 */
@Getter
@Setter
@Entity
public class Note extends BaseEntity {
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNote;
}
