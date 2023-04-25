package com.example.bai_test.config.mapper;

import com.example.bai_test.response.BranResponse;
import com.example.bai_test.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper2 {

    BrandMapper2 mapper = Mappers.getMapper(BrandMapper2.class);

    BranResponse brandConvertToDTO(Brand brand);

}
