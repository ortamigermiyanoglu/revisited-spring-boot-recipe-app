package com.sumutella.recipe.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author sumutella
 * @time 6:00 PM
 * @since 1/1/2020, Wed
 */
public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);
}
