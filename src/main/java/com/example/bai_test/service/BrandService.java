package com.example.bai_test.service;

import com.example.bai_test.response.BranResponse;

import java.util.List;

public interface BrandService {

    List<BranResponse> getAll();

    void delete(Long id);

    BranResponse getOne(Long id);
}
