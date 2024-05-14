package com.blogapplication.app.service;

import com.blogapplication.app.entity.Category;
import com.blogapplication.app.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategory();
    CategoryDto deleteCategoryById(Long id);
}
