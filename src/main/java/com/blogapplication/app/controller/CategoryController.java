package com.blogapplication.app.controller;


import com.blogapplication.app.payload.CategoryDto;
import com.blogapplication.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategoryDto = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategoryDto, HttpStatus.CREATED);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long id){
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> allCategories = categoryService.getAllCategory();
        return ResponseEntity.ok(allCategories);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable("id") Long id){
        CategoryDto categoryDto = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(categoryDto);
    }




}
