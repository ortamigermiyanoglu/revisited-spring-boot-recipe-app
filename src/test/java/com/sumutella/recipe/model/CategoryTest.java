package com.sumutella.recipe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sumutella
 * @time 10:49 AM
 * @since 12/25/2019, Wed
 */
class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        category.setId(4L);

        assertEquals(4L, category.getId());

    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}