package com.example.bai_test.service;

import com.example.bai_test.response.SubCategoryResponse;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryResponse> getAll();

    List<SubCategoryResponse> getAllSubById(Long id);
}
