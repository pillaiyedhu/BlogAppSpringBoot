package com.blogapplication.app.service.impl;

import com.blogapplication.app.entity.Category;
import com.blogapplication.app.exception.ResourceNotFoundException;
import com.blogapplication.app.payload.CategoryDto;
import com.blogapplication.app.respository.CategoryRepository;
import com.blogapplication.app.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        categoryRepository.save(category);
        CategoryDto savedCategoryDto = modelMapper.map(category,CategoryDto.class);
        return null;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId",id));
        CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> allCategory = categoryRepository.findAll();
        List<CategoryDto> allCategoryDto = new ArrayList<>();
        allCategory.stream().forEach(category -> {
            CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
            allCategoryDto.add(categoryDto);
        });
        return allCategoryDto;
    }

    @Override
    public CategoryDto deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId",id));
        categoryRepository.delete(category);
        CategoryDto categoryDto = modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }
}
