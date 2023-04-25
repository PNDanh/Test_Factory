package com.example.bai_test.config.mapper;

import com.example.bai_test.response.CategoryResponse;
import com.example.bai_test.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Category convertToEntity(CategoryMapper categoryMapper) {
        Category category = modelMapper.map(categoryMapper, Category.class);
        return category;
    }

    public CategoryResponse convertToDTO(Category category) {
        CategoryResponse categoryResponse = modelMapper.map(category, CategoryResponse.class);
        return categoryResponse;
    }
}
