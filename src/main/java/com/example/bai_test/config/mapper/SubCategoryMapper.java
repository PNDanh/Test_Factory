package com.example.bai_test.config.mapper;

import com.example.bai_test.response.SubCategoryResponse;
import com.example.bai_test.entity.SubCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryMapper {

    @Autowired
    private ModelMapper modelMapper;
    public SubCategory convertToEntity(SubCategoryResponse subCategoryResponse){
        SubCategory subCategory = modelMapper.map(subCategoryResponse,SubCategory.class);
        return subCategory;
    }

    public SubCategoryResponse convertToDTO(SubCategory subCategory){
        SubCategoryResponse categoryDTO = modelMapper.map(subCategory, SubCategoryResponse.class);
        return categoryDTO;
    }
}
