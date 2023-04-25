package com.example.bai_test.service;

import com.example.bai_test.response.ProductResponsee;

import java.util.List;

public interface ProductService {

    List<ProductResponsee> getAll();

    ProductResponsee add(ProductResponsee productResponsee);

    ProductResponsee getOne(Long id);

    void update(Long id, ProductResponsee productResponsee);

    void delete(Long id);

    ProductResponsee getOneByID(Long id);

}
