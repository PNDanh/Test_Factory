package com.example.bai_test.service.imp;

import com.example.bai_test.response.SubCategoryResponse;
import com.example.bai_test.entity.SubCategory;
import com.example.bai_test.config.mapper.SubCategoryMapper;
import com.example.bai_test.repository.SubCategoryRepository;
import com.example.bai_test.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImp implements SubCategoryService {

    @Autowired
    private SubCategoryRepository categoryRepository;

    @Autowired
    private SubCategoryMapper subCategoryMapper;


    @Override
    public List<SubCategoryResponse> getAll() {
        List<SubCategoryResponse> subCategoryResponses = new ArrayList<>();
        for (SubCategory sct : categoryRepository.findAll()) {
            subCategoryResponses.add(subCategoryMapper.convertToDTO(sct));
        }
        return subCategoryResponses;
    }

    @Override
    public List<SubCategoryResponse> getAllSubById(Long id) {
        List<SubCategoryResponse> subCategoryResponses = new ArrayList<>();
        for (SubCategory sct : categoryRepository.getAllSubById(id)) {
            subCategoryResponses.add(subCategoryMapper.convertToDTO(sct));
        }
        return subCategoryResponses;
    }
}
