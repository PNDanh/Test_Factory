package com.example.bai_test.config.mapper;

import com.example.bai_test.response.ProductResponsee;
import com.example.bai_test.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Product convertToEntity(ProductResponsee productResponsee){
        Product product = modelMapper.map(productResponsee,Product.class);
        return product;
    }

    public ProductResponsee convertToDTO(Product product){
        ProductResponsee productResponsee = modelMapper.map(product, ProductResponsee.class);
        return productResponsee;
    }

}
