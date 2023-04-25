package com.example.bai_test.config.mapper;

import com.example.bai_test.response.BranResponse;
import com.example.bai_test.entity.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Brand convertToEntity(BranResponse branResponse) {
        Brand brand = modelMapper.map(branResponse, Brand.class);
        return brand;
    }

    public BranResponse convertToDTO(Brand brand) {
        BranResponse branResponse = modelMapper.map(brand, BranResponse.class);
        return branResponse;
    }
}
